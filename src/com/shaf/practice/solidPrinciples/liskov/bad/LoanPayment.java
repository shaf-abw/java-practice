package com.shaf.practice.solidPrinciples.liskov.bad;

/**
 * This is loan interface responsible for payment related operations on loan account
 * LoanPayment implemented by actual loans like Home Loan, Credit Card Loan etc.
 * For credit card/personal loan which is unsecured foreclosure and repayment is not allowed.
 */
public interface LoanPayment {
    public void doPayment(int amount);
    public void foreCloseLoan();
    public void doRepayment(int amount);
}
