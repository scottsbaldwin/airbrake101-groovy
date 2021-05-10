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

You must source your `.airbrake.env` variables file. The sample app will read values from that file at runtime.

```
source .airbrake.env
```

Run the sample app with this command to get the usage help.

```
❯ groovy app/SampleApp
USAGE: command amount
    command: either deposit or withdraw
    amount:  the amount to deposit or withdraw
```