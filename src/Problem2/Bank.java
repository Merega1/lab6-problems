package Problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }
    void addCustomer(Customer newCustomer){
        if(customers.contains(newCustomer)){
            throw new IllegalArgumentException("Customer already exists");
        }
        customers.add(newCustomer);
    }
    public void addTransaction(Customer customer, double amount){
        int idx = customers.indexOf(customer);
        if(idx == -1){
            throw new IllegalArgumentException("Customer does not exist");
        }

        customers.get(idx).addTransaction(amount);
    }
    public void printCustomer(Customer c){
        for(Customer customer : customers){
            if(customer.equals(c)){
                System.out.println("Customer: " + customer.getName());
                for (Double transaction : customer.getTransactions()) {
                    double amount = transaction; // Unboxing
                    System.out.println(amount);
                }
            }
        }
    }
}
