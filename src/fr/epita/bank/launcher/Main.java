package fr.epita.bank.launcher;

import fr.epita.bank.services.AccountService;
import fr.epita.bank.datamodel.*;
import fr.epita.bank.services.ConsoleActivityService;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        System.out.println("welcome to this bank application");
        Scanner consoleReader = new Scanner(System.in);

        ConsoleActivityService activities = new ConsoleActivityService(consoleReader);

        //customer creation
        Customer someCustomer = activities.createCustomer();
        SavingsAccount savingsAccount = activities.createSavingsAccount(someCustomer);
        InvestmentAccount investmentAccount = activities.createInvestmentAccount(someCustomer);
        activities.withdrawFromAccount(savingsAccount);
        activities.buyStocks(investmentAccount);

        System.out.println(savingsAccount);



    }

}
