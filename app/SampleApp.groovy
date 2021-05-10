// TODO: Add a Grape dependency on javabrake
// @Grapes(
//   @Grab(group='io.airbrake', module='javabrake', version='0.2.3')
// )
package app

import io.airbrake.training.*
import groovy.util.logging.Log
import java.util.logging.Level

// TODO: Import the necessary packages for the Airbrake notifier (javabrake)
// import io.airbrake.javabrake.Notice
// import io.airbrake.javabrake.Notifier
// import io.airbrake.javabrake.Config

@Log
class SampleApp {
    BankAccount acct = new BankAccount()
    
    // TODO: Add a field for a global Airbrake notifier used by our application
    // Notifier airbrake

    SampleApp() {
        // TODO: SIMPLE STEP - Initialize the global notifier variable with hard-coded values
        // def config = new Config()
        // config.projectId = 000000
        // config.projectKey = "your_project_key_here"
        // airbrake = new Notifier(config)

        // TODO: ADVANCED STEP - Initialize the global notifier variable with hard-coded values
        // def env = System.getenv()
        // def config = new Config()
        // config.projectId = env['AB_PROJECT_ID'] as int
        // config.projectKey = env['AB_PROJECT_KEY']
        // airbrake = new Notifier(config)
    }

    void makeDeposit(int amount) {
        try {
            acct.deposit(amount)
        } catch (UnsupportedOperationException e) {
            log.log(Level.SEVERE, e.message)
            // TODO: Notify Airbrake that an error occurred here
            // airbrake.report(e).get()
        } catch (IllegalArgumentException e) {
            log.log(Level.SEVERE, e.message)
            // TODO: Notify Airbrake that an error occurred here
            // airbrake.report(e).get()
        }
    }

    void withdrawMoney(int amount) {
        try {
            acct.withdraw(amount)
        } catch (UnsupportedOperationException e) {
            log.log(Level.SEVERE, e.message)
            // TODO: Notify Airbrake that an error occurred here
            // airbrake.report(e).get()
        } catch (IllegalArgumentException e) {
            log.log(Level.SEVERE, e.message)
            // TODO: Notify Airbrake that an error occurred here
            // airbrake.report(e).get()
        }
    }

    static void main(String... args) {
        if (args.length < 2) {
            println("USAGE: command amount")
            println("    command: either deposit or withdraw")
            println("    amount:  the amount to deposit or withdraw")
            System.exit(1)
        }

        def sampleApp = new SampleApp()
        def amount = 0
        try {
            args[1] as int
        } catch (NumberFormatException e) {
            println("Your second argument must be a whole number.")
            System.exit(1)
        }

        switch(args[0]) {
            case "deposit":
                sampleApp.makeDeposit(args[1] as int)
                break
            case "withdraw":
                sampleApp.withdrawMoney(args[1] as int)
                break
            default:
                println("Your first argument must be deposit or withdraw.")
                System.exit(1)
        }
        System.exit(0)
    }
}
