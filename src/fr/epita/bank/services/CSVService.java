package fr.epita.bank.services;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVService {

    public static Map<Integer, Customer> loadCustomers() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("customers.csv"));
        Map<Integer, Customer> customers = new LinkedHashMap<>();
        lines.remove(0);
        for (String line : lines) {
            String[] parts = line.split(",");
            Customer customer = new Customer(Integer.parseInt(parts[0]), parts[1], parts[2]);
            customers.put(customer.getId(), customer);
        }
        return customers;
    }


    public static Map<Integer, Account> loadAccounts(Map<Integer, Customer> customers) throws IOException {
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
            Customer customer = customers.get(customer_id);
            if ("savings".equals(type)){
                SavingsAccount account = new SavingsAccount(id, amount, customer, interest_rate);
                accounts.put(id,account);
            } else if ("investment".equals(type)){
                InvestmentAccount account = new InvestmentAccount(id, amount, customer);
                accounts.put(id, account);
            } else {
                System.out.printf("problem, unrecognized type %s\n", type);
            }
        }
        System.out.printf("accounts: %d\n", accounts.size());
        return accounts;
    }
}
