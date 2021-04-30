# Airbrake 101 with Groovy

This repository is a sample for getting started with Airbrake using a simple Groovy script. The script was adapted from a [Bank Account Exercise](https://exercism.io/tracks/groovy/exercises/bank-account/solutions/26bf12a2d1e44d68b48546eec92945e3) from exercism.io.

## Preparation

Clone this repository, and create a file called `.airbrake.env` in the root directory of the repository. Add these lines:

```
export AB_PROJECT_ID=
export AB_PROJECT_KEY=
```

You will need an Airbrake project ID and project key in order for your notifier to communicate with the Airbrake API. Create an account, and your first project at https://airbrake.io. Then, navigate to your project's settings page to get the ID and project key. Paste those values in your `.airbrake.env` file.

## Usage

You must source your `.airbrake.env` variables file. The `Airbrake101.groovy` script will read values from that file at runtime.

```
source .airbrake.env
```

The `Airbrake101` class has the ability to run 3 scenarios on a bank account. Each of the scenarios will encounter an error that will get sent to Airbrake.

### Scenario 1

Scenario 1 will try to deposit money in an account which is not opened. This is not allowed! Trigger scenario 1 by issuing the following command.

```
groovy Airbrake101 1
```

After this command exits, open your Airbrake dashboard and find your first error!

### Scenario 2

Scenario 2 will try to deposit a negative money amount in your account. This is not allowed! Trigger scenario 2 by issuing the following command.

```
groovy Airbrake101 2
```

Your Airbrake dashboard will show that you have a new error. Try running this command a few times to trigger several occurrences of the same error. What changed in your Airbrake dashboard? Did you find the individual occurrences?

### Scenario 3

Scenario 3 will try to withdraw an amount of money that exceeds your current balance. This is not allowed! Trigger scenario 3 by issuing the following command.

```
groovy Airbrake101 3
```

Now your dashboard has a third type, or group, of errors!