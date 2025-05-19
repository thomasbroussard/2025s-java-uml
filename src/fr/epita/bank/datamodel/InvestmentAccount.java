package fr.epita.bank.datamodel;

public class InvestmentAccount extends Account {

    public InvestmentAccount(Integer id, Double balance, Customer customer){
        this.balance = balance;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "InvestmentAccount{" +
                "balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
