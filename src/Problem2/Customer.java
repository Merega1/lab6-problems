package Problem2;

import java.util.ArrayList;

public class Customer {
    private final String name;
    private ArrayList<Double> transactions;


    public Customer(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount){
        transactions.add(amount);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Customer)) return false;

        Customer other = (Customer) obj;
        return name.equals(other.getName());
    }
}
