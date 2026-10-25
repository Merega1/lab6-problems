package Problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Library capacity: ");
        int capacity = Integer.parseInt(scan.nextLine());

        Library library = new Library(capacity);

        library.add(new Novel("1984", "George Orwell", 328, 120));
        library.add(new Magazine("Saba7", "October", 2026));

        int choice;

        do {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add document");
            System.out.println("2. Display documents");
            System.out.println("3. Delete document");
            System.out.println("4. Search document");
            System.out.println("5. Display authors");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = Integer.parseInt(scan.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Document type:");
                    System.out.println("1. Book");
                    System.out.println("2. Magazine");
                    System.out.println("3. Dictionary");
                    System.out.println("4. Novel");
                    System.out.println("5. Textbook");
                    System.out.print("Type: ");

                    int type = Integer.parseInt(scan.nextLine());

                    if (type < 1 || type > 5) {
                        System.out.println("Invalid type.");
                        break;
                    }

                    System.out.print("Title: ");
                    String title = scan.nextLine();

                    Document doc;

                    if (type == 2) {
                        System.out.print("Month: ");
                        String month = scan.nextLine();

                        System.out.print("Year: ");
                        int year = Integer.parseInt(scan.nextLine());

                        doc = new Magazine(title, month, year);

                    } else if (type == 3) {
                        System.out.print("Language: ");
                        String language = scan.nextLine();

                        doc = new Dictionary(title, language);

                    } else {
                        System.out.print("Author: ");
                        String author = scan.nextLine();

                        System.out.print("Number of pages: ");
                        int pages = Integer.parseInt(scan.nextLine());

                        if (type == 4) {
                            System.out.print("Price: ");
                            double price = Double.parseDouble(scan.nextLine());
                            doc = new Novel(title, author, pages, price);

                        } else if (type == 5) {
                            System.out.print("Level: ");
                            String level = scan.nextLine();
                            doc = new Textbook(title, author, pages, level);

                        } else {
                            doc = new Book(title, author, pages);
                        }
                    }

                    System.out.println(
                            library.add(doc) ? "Added." : "Library is full."
                    );
                    break;

                case 2:
                    library.displayDocuments();
                    break;

                case 3:
                    System.out.print("Record number to delete: ");
                    int deleteId = Integer.parseInt(scan.nextLine());

                    Document toDelete = library.document(deleteId);

                    System.out.println(
                            library.delete(toDelete) ? "Deleted." : "Not found."
                    );
                    break;

                case 4:
                    System.out.print("Record number to search: ");
                    int searchId = Integer.parseInt(scan.nextLine());

                    Document found = library.document(searchId);

                    System.out.println(
                            found == null ? "Not found." : found
                    );
                    break;

                case 5:
                    library.displayAuthors();
                    break;

                case 0:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

}
