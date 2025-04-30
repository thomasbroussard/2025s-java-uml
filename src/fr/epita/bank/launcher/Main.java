package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;

public class Main {

    public static void main(String[] args) {
        System.out.println("welcome to this bank application");
        Customer someCustomer = new Customer("thomas", "Paris");
        someCustomer.setName("thomas");
        someCustomer.setAddress("Paris");

        // I would like to have a small scenario where customer creates 2 accounts
        // 1 savings account: initial balance: 500€, intereste rate is 3%
        // 1 investment account: initial balance : 1000€
        // the customer withdraws 200€ from the savings
        // the customer buys 5 stocks of gold (unit price: 100€) using his investment account
        // the commission is 5% of all transactions

        //display the final states of each of the involved instances




    }
}
