package com.shaf.practice.solidPrinciples.singleResponsiblity;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNumber(123);
        account.setFirstName("Shafeeque");
        account.setTotalAmount(BigDecimal.valueOf(100000));
        AccountOperations accountOperations = new AccountOperations();
        accountOperations.addAccount(account);

        TransactionOperations transactionOperations = new TransactionOperations();
        transactionOperations.deposit(BigDecimal.valueOf(123),123);
    }
}
