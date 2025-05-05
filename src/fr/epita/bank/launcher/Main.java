package fr.epita.bank.launcher;

import fr.epita.bank.AccountService;
import fr.epita.bank.datamodel.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("welcome to this bank application");
        Customer someCustomer = new Customer("thomas", "Paris");

        someCustomer.setName("thomas");
        someCustomer.setAddress("Paris");

        // I would like to have a small scenario where customer creates 2 accounts
        // 1 savings account: initial balance: 500€, interest rate is 3%
        SavingsAccount savingsAccount = new SavingsAccount(500.0, someCustomer, 0.03);


        // 1 investment account: initial balance : 1000€
        InvestmentAccount investmentAccount = new InvestmentAccount(1000.0, someCustomer);


        // the customer withdraws 200€ from the savings
        Double requestedMoney = 200.0;

        AccountService.withdraw(savingsAccount, requestedMoney);

        // the customer buys 5 stocks of gold (unit price: 100€) using his investment account
        Stock goldStock = new Stock(100.0, "GOLD");
        StockOrder stockOrder = new StockOrder(
                goldStock.getCurrentUnitPrice(),
                5,
                0.0,
                goldStock,
                investmentAccount
        );

        double grossAmount = stockOrder.getCurrentUnitPrice() * stockOrder.getQuantity();
        Double commission = grossAmount * 0.05;
        stockOrder.setCommission(commission);
        double netAmount = grossAmount + commission;
        investmentAccount.setBalance(savingsAccount.getBalance() - netAmount);



        // the commission is 5% of all transactions

        //display the final states of each of the involved instances




    }
}
