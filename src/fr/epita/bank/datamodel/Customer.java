package fr.epita.bank.datamodel;


public class Customer {
    private int id;
    private String name;
    private String address;

    public Customer(int id, String name, String address){
        this.address = address;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null){
            return;
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
