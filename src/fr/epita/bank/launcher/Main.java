package fr.epita.bank.launcher;

import fr.epita.bank.services.AccountService;
import fr.epita.bank.datamodel.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("welcome to this bank application");
        Scanner consoleReader = new Scanner(System.in);

        //customer creation
        Customer someCustomer = createCustomer(consoleReader);


        /*
        Customer someCustomer = new Customer("thomas", "Paris");

        someCustomer.setName("thomas");
        someCustomer.setAddress("Paris");
*/
        // I would like to have a small scenario where customer creates 2 accounts
        // 1 savings account: initial balance: 500€, interest rate is 3%
        Double balance = readDoubleFromConsole("please enter the balance for the savings:", consoleReader);
        Double interestRate = readDoubleFromConsole("please enter the interest rate", consoleReader);
        SavingsAccount savingsAccount = new SavingsAccount(balance, someCustomer, interestRate);


        // 1 investment account: initial balance : 1000€
        double investBalance = readDoubleFromConsole("input a balance for the investment account", consoleReader);
        InvestmentAccount investmentAccount = new InvestmentAccount(investBalance, someCustomer);


        // the customer withdraws 200€ from the savings
        Double requestedMoney = readDoubleFromConsole("what amount would you like to withdraw", consoleReader);

        AccountService.withdraw(savingsAccount, requestedMoney);

        // the customer buys 5 stocks of gold (unit price: 100€) using his investment account
        Stock goldStock = new Stock(100.0, "GOLD");

        StockOrder stockOrder = AccountService.buyStocks(investmentAccount, goldStock, 5);
        // the commission is 5% of all transactions

        //display the final states of each of the involved instances
        System.out.println(savingsAccount);



    }

    private static Customer createCustomer(Scanner consoleReader) {
        String userName = readFromConsole("please enter a user name", consoleReader);
        String userAddress = readFromConsole("please enter the user address", consoleReader);
        Customer someCustomer = new Customer(userName, userAddress);
        return someCustomer;
    }

    private static String readFromConsole(String prompt, Scanner consoleReader) {
        System.out.println(prompt);
        String userResponse = consoleReader.nextLine();
        return userResponse;
    }

    private static Double readDoubleFromConsole(String prompt, Scanner consoleReader) {
       return Double.parseDouble(readFromConsole(prompt, consoleReader));
    }
}
