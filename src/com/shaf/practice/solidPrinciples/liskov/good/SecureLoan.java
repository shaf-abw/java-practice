package com.shaf.practice.solidPrinciples.liskov.good;

public interface SecureLoan extends LoanPayment {
    public void foreCloseLoan();
}
