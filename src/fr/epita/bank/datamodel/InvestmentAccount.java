package fr.epita.bank.datamodel;

public class InvestmentAccount extends Account {

    public InvestmentAccount(Double balance, Customer customer){
        this.balance = balance;
        this.customer = customer;
    }
}
