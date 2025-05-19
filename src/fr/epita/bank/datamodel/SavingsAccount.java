package fr.epita.bank.datamodel;

public class SavingsAccount extends Account{
    Double interestRate;

    public SavingsAccount(Integer id, Double balance, Customer customer, Double interestRate){
        this.balance = balance;
        this.customer = customer;
        this.interestRate = interestRate;
        this.id = id;
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
