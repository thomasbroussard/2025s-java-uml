package fr.epita.bank.services;

import fr.epita.bank.datamodel.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
}
