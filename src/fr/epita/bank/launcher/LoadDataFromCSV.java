package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoadDataFromCSV {

    public static void main(String[] args) throws IOException {
        //1. load all the data from csv under 4 different lists, do not consider the links at this step
        //2. now load data in the right order, and try to assign the corresponding data to each instance
        // for instance: account 1 is linked to customer 1 account1.setCustomer(customer1)
        //3. display the whole graph of data (HARD)

        List<String> lines = Files.readAllLines(Path.of("accounts.csv"));
        lines.remove(0);
        Map<Integer, Account> accounts = new LinkedHashMap<>();
        for (String line : lines) {
            System.out.println(line);
            String[] lineParts = line.split(",");
            Integer id = Integer.parseInt(lineParts[0]);
            String type = lineParts[1];
            double amount = Double.parseDouble(lineParts[2]);
            String linePart = lineParts[3];
            double interest_rate = 0;
            if (linePart!= null &&  !linePart.isEmpty()) {
                interest_rate = Double.parseDouble(linePart);
            }

            int customer_id = Integer.parseInt(lineParts[4]);
            if ("savings".equals(type)){
                SavingsAccount account = new SavingsAccount(id, amount, null, interest_rate);
                accounts.put(id,account);
            } else if ("investment".equals(type)){
                InvestmentAccount account = new InvestmentAccount(id, amount, null);
                accounts.put(id, account);
            } else {
                System.out.printf("problem, unrecognized type %s\n", type);
            }
        }
        System.out.printf("accounts: %d\n", accounts.size());
        accounts.get(10);

    }
}
