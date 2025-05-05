package fr.epita.bank.datamodel;

public class SavingsAccount extends Account{
    Double interestRate;

    public SavingsAccount(Double balance, Customer customer, Double interestRate){
        this.balance = balance;
        this.customer = customer;
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "interestRate=" + interestRate +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
