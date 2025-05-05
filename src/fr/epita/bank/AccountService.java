package fr.epita.bank;

import fr.epita.bank.datamodel.Account;

public class AccountService {

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
}
