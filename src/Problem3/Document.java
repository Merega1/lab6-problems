package Problem3;

public class Document {
    private static int nextNum = 1;
    protected final int numEnreg;
    protected String title;

    public Document(String title){
        this.title = title;
        this.numEnreg = nextNum++;
    }

    public int getNumEnreg() {
        return numEnreg;
    }

    @Override
    public String toString() {
        return numEnreg + " Document title: " + this.title;
    }
}
