package fr.epita.bank.datamodel;

public class StockOrder {
    Double currentUnitPrice;
    Integer quantity;
    Double commission;
    Stock stock;
    InvestmentAccount account;

    public StockOrder(Double currentUnitPrice, Integer quantity, Double commission, Stock stock, InvestmentAccount account) {
        this.currentUnitPrice = currentUnitPrice;
        this.quantity = quantity;
        this.commission = commission;
        this.stock = stock;
        this.account = account;
    }

    public Double getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(Double currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public InvestmentAccount getAccount() {
        return account;
    }

    public void setAccount(InvestmentAccount account) {
        this.account = account;
    }
}
