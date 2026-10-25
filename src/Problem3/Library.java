package Problem3;

import java.util.ArrayList;

public class Library {
    private final int capacity;
    private final ArrayList<Document> documents;

    public Library(int capacity) {
        this.capacity = capacity;
        this.documents = new ArrayList<>();
    }

    public void displayDocuments() {
        for (Document doc : documents) {
            System.out.println(doc);
        }
    }

    public boolean add(Document doc) {
        if (doc == null || documents.size() >= capacity) {
            return false;
        }
        return documents.add(doc);
    }

    public boolean delete(Document doc) {
        return documents.remove(doc);
    }

    public Document document(int numEnrg) {
        for (Document doc : documents) {
            if (doc.getNumEnreg() == numEnrg) {
                return doc;
            }
        }
        return null;
    }

    public void displayAuthors() {
        for (Document doc : documents) {
            if (doc instanceof Book) {
                Book book = (Book) doc;
                System.out.println(book.getAuthor());
            }
        }
    }
}
