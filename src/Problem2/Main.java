
package Problem2;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("My Bank");
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");
        Customer charlie = new Customer("Charlie");

        bank.addCustomer(alice);
        bank.addCustomer(bob);

        bank.addTransaction(alice, 1000.0);
        bank.addTransaction(alice, -250.0);
        bank.addTransaction(alice, 500.0);
        bank.addTransaction(bob, 2000.0);
        bank.addTransaction(bob, -300.0);

        bank.printCustomer(alice);
        bank.printCustomer(bob);

        try {
            bank.addCustomer(new Customer("Alice"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.addTransaction(charlie, 500.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Customer anotherAlice = new Customer("Alice");

        bank.addTransaction(anotherAlice, 150.0);
        bank.printCustomer(alice);
    }
}