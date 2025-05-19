package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.services.CSVService;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LoadDataFromCSV {

    public static void main(String[] args) throws IOException {
        //1. load all the data from csv under 4 different lists, do not consider the links at this step
        //2. now load data in the right order, and try to assign the corresponding data to each instance
        // for instance: account 1 is linked to customer 1 account1.setCustomer(customer1)
        //3. display the whole graph of data (HARD)


        Map<Integer, Customer> customers = CSVService.loadCustomers();

        System.out.println(customers.get(3));
        Collection<Customer> values = customers.values();
        Map<String,Integer> countPerCity = new HashMap<>();
        for (Customer customer : values) {
            String currentAddress = customer.getAddress();
            Integer i = countPerCity.get(currentAddress);
            if (i == null) {
                countPerCity.put(currentAddress, 1);
            }else{
                countPerCity.put(currentAddress, ++i);
            }
        }
        System.out.println(countPerCity);

        Map<Integer, Account> accounts = CSVService.loadAccounts(customers);





    }

}
