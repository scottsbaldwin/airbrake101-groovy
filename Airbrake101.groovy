@Grapes(
  @Grab(group='io.airbrake', module='javabrake', version='0.2.3')
)
import com.airbrake.training.*
import io.airbrake.javabrake.Notifier
import io.airbrake.javabrake.Config

class Airbrake101 {
    Notifier airbrake
    BankAccount acct = new BankAccount()

    static void main(String... args) {
        // We expect an argument in order to demo
        // different scenarios.
        if (args.length < 1) {
            println("Please provide a demo scenario as an argument")
            System.exit(1)
        }

        def training = new Airbrake101()
        switch(args[0]) {
            case "1":
                training.demoCase1()
                break
            case "2":
                training.demoCase2()
                break
            case "3":
                training.demoCase3()
                break
            default:
                println("Case not supported")
                System.exit(1)
        }
        System.exit(0)
    }

    Airbrake101() {
        def env = System.getenv()
        def config = new Config()

        config.projectId = env['AB_PROJECT_ID'] as int
        config.projectKey = env['AB_PROJECT_KEY']
        airbrake = new Notifier(config)
    }

    /**
     * Tries to depost money on an account that is not opened.
     */
    void demoCase1() {
        try {
            acct.deposit(100)
        } catch (UnsupportedOperationException e) {
            // Use reportSync because the async returns a future
            // but the script exits and the report never happens
            airbrake.reportSync(e)
        }
    }
    
    /**
     * Tries to deposit a negative money amount in an account
     */
    void demoCase2() {
        try {
            acct.open()
            acct.deposit(-100)
        } catch (IllegalArgumentException e) {
            airbrake.reportSync(e)
        }
    }

    /**
     * Tries to withdraw more money than is available in the account
     */
    void demoCase3() {
        try {
            acct.open()
            acct.withdraw(100)
        } catch (IllegalArgumentException e) {
            airbrake.reportSync(e)
        }
    }
}
