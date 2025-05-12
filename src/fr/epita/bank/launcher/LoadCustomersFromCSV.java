package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoadCustomersFromCSV {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("customers.csv"));

        List<Customer> customers = new ArrayList<>();
        lines.remove(0);
        for (String line : lines){
            String[] parts = line.split(",");
            Customer customer = new Customer(Integer.parseInt(parts[0]), parts[1], parts[2]);
            customers.add(customer);
        }
        System.out.println(customers);

    }
}
