package fr.epita.bank.datamodel;

public class Stock {
    Double currentUnitPrice;
    String name;

    public Stock(Double currentUnitPrice, String name) {
        this.currentUnitPrice = currentUnitPrice;
        this.name = name;
    }

    public Double getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(Double currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
