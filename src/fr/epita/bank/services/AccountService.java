package fr.epita.bank.services;

import fr.epita.bank.datamodel.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AccountService {

    public static final double TRANSACTION_COMMISSION = 0.05;

    /**
     * the "withdraw" method is in charge of operating a withdrawal on an account
     * the account balance should be sufficient regarding the amount requested
     * <pre><code>
     *     Account account;
     *     AccountService.withdraw(account, 100.0);
     * </code></pre>
     *
     * @param account the account
     * @param amount the amount requested
     * @return the amount actually withdrawn, 0 if the balance was insufficient
     */
    public static Double withdraw(Account account, Double amount){
        Double balance = account.getBalance();
        if (balance < amount){
            System.out.println("the balance is insufficient, current balance :" + balance);
            return 0.0;
        }else {
            account.setBalance(balance - amount);
        }
        return amount;
    }

    public static StockOrder buyStocks(InvestmentAccount account, Stock stock, Integer quantity ){
        StockOrder stockOrder = new StockOrder(
                stock.getCurrentUnitPrice(),
                quantity,
                0.0,
                stock,
                account
        );

        double grossAmount = stockOrder.getCurrentUnitPrice() * stockOrder.getQuantity();
        Double commission = grossAmount * TRANSACTION_COMMISSION;
        stockOrder.setCommission(commission);
        double netAmount = grossAmount + commission;
        account.setBalance(account.getBalance() - netAmount);
        return stockOrder;
    }


    public static Map<String, Integer> groupAndCountCustomersPerCity(Map<Integer, Customer> customers) {
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
        return countPerCity;
    }
}
