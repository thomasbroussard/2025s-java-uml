package fr.epita.bank.services;

import fr.epita.bank.datamodel.*;

import java.util.Scanner;

public class ConsoleActivityService {


    private Scanner consoleReader;


    public ConsoleActivityService(Scanner input){
        this.consoleReader = input;
    }

    public void buyStocks(InvestmentAccount investmentAccount) {
        // the customer buys 5 stocks of gold (unit price: 100€) using his investment account
        Stock goldStock = new Stock(100.0, "GOLD");

        StockOrder stockOrder = AccountService.buyStocks(investmentAccount, goldStock, 5);
    }

    public void withdrawFromAccount(SavingsAccount savingsAccount) {
        Double requestedMoney = readDoubleFromConsole("what amount would you like to withdraw");

        AccountService.withdraw(savingsAccount, requestedMoney);
    }

    public InvestmentAccount createInvestmentAccount(Customer someCustomer) {
        double investBalance = readDoubleFromConsole("input a balance for the investment account");
        InvestmentAccount investmentAccount = new InvestmentAccount(investBalance, someCustomer);
        return investmentAccount;
    }

    public SavingsAccount createSavingsAccount(Customer someCustomer) {
        Double balance = readDoubleFromConsole("please enter the balance for the savings:");
        Double interestRate = readDoubleFromConsole("please enter the interest rate");
        SavingsAccount savingsAccount = new SavingsAccount(balance, someCustomer, interestRate);
        return savingsAccount;
    }

    public  Customer createCustomer() {
        String userName = readFromConsole("please enter a user name");
        String userAddress = readFromConsole("please enter the user address" );
        Customer someCustomer = new Customer(1 ,userName, userAddress); // either generate it or ask user about it
        return someCustomer;
    }

    public  String readFromConsole(String prompt) {
        System.out.println(prompt);
        String userResponse = consoleReader.nextLine();
        return userResponse;
    }

    public  Double readDoubleFromConsole(String prompt) {
        return Double.parseDouble(readFromConsole(prompt));
    }


}
