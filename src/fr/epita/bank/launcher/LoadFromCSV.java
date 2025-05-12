package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LoadFromCSV {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Path.of("customers.csv"));

        List<Customer> customers = new ArrayList<>();
        for (String line : lines){
            String[] parts = line.split(",");
            parts[0]; //id
            parts[1]; //name
            parts[2]; //address
            Customer customer = new Customer();
            customers.add(customer);
        }
        System.out.println(customers);

    }
}
