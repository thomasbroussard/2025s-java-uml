package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.services.AccountService;
import fr.epita.bank.services.CSVService;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.Histogram;
import org.knowm.xchart.SwingWrapper;

import java.io.IOException;
import java.util.ArrayList;
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

        Map<String, Integer> countPerCity = AccountService.groupAndCountCustomersPerCity(customers);
        System.out.println(countPerCity);

        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("chart")
                .xAxisTitle("Mean")
                .yAxisTitle("Count")
                .build();

        chart.addSeries("principal", new ArrayList<>(countPerCity.keySet()), new ArrayList<>(countPerCity.values()));

        new SwingWrapper(chart).displayChart();

        Map<Integer, Account> accounts = CSVService.loadAccounts(customers);

        Collection<Account> values = accounts.values();
        Map<Integer, Double> totalBalancePerCustomer = new HashMap<>();
        for (Account account : values) {
            int id = account.getCustomer().getId();
            Double v = totalBalancePerCustomer.get(id);
            if (v == null) {
                totalBalancePerCustomer.put(id, account.getBalance());
            }else{
                totalBalancePerCustomer.put(id, v + account.getBalance());
            }
        }

        System.out.println(totalBalancePerCustomer);

        CategoryChart chart1 = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("chart")
                .xAxisTitle("Mean")
                .yAxisTitle("Count")
                .build();

        chart1.addSeries("principal", new ArrayList<>(totalBalancePerCustomer.keySet()), new ArrayList<>(totalBalancePerCustomer.values()));

        new SwingWrapper(chart1).displayChart();



    }


}
