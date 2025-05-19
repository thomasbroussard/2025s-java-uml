package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.services.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoadCustomersFromCSV {

    public static void main(String[] args) throws IOException {

        Map<Integer, Customer> customers = CSVService.loadCustomers();
        System.out.println(customers);

    }


}
