package io.airbrake.training

import groovy.transform.Synchronized

class BankAccount {
    String ERROR_ACCOUNT_NOT_OPENED = "You cannot interact with an account that is not opened."
    int balance = 0
    boolean isOpened = false

    @Synchronized
    void open() {
        isOpened = true
        balance = 0
    }

    @Synchronized
    void close() {
        isOpened = false
    }

    @Synchronized
    void deposit(int amount) {
        if (!isOpened) {
            throw new UnsupportedOperationException(ERROR_ACCOUNT_NOT_OPENED)
        }
        if (amount < 0) {
            throw new IllegalArgumentException("You cannot deposit a negative money amount.")
        }
        balance += amount
    }

    @Synchronized
    void withdraw(int amount) {
        if (!isOpened) {
            throw new UnsupportedOperationException(ERROR_ACCOUNT_NOT_OPENED)
        }
        if (amount < 0) {
            throw new IllegalArgumentException("You cannot withdraw a negative money amount.")
        }
        if (amount > balance) {
            throw new IllegalArgumentException("You do not have enough money to withdraw.")
        }
        balance -= amount
    }

    @Synchronized
    int getBalance() {
        if (!isOpened) {
            throw new UnsupportedOperationException(ERROR_ACCOUNT_NOT_OPENED)
        }
        return balance
    }
}