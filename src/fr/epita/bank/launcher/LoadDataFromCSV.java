package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoadDataFromCSV {

    public static void main(String[] args) throws IOException {
        //1. load all the data from csv under 4 different lists, do not consider the links at this step
        //2. now load data in the right order, and try to assign the corresponding data to each instance
        // for instance: account 1 is linked to customer 1 account1.setCustomer(customer1)
        //3. display the whole graph of data (HARD)

        List<String> lines = Files.readAllLines(Path.of("accounts.csv"));
        lines.remove(0);
        List<Account> accounts = new ArrayList<>();
        for (String line : lines) {
            System.out.println(line);
            String[] lineParts = line.split(",");
            String id = lineParts[0];
            String type = lineParts[1];
            double amount = Double.parseDouble(lineParts[2]);
            double interest_rate = Double.parseDouble(lineParts[3]);
            int customer_id = Integer.parseInt(lineParts[4]);
            if ("savings".equals(type)){
                SavingsAccount account = new SavingsAccount(amount, null, interest_rate);
                accounts.add(account);
            } else if ("investment".equals(type)){
                InvestmentAccount account = new InvestmentAccount(amount, null);
                accounts.add(account);
            } else {
                System.out.printf("problem, unrecognized type %s\n", type);
            }


        }


    }
}
