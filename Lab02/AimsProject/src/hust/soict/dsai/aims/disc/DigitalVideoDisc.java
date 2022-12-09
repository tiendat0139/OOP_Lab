package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
    private static int nbDigitalVideoDisc = 0;

    public DigitalVideoDisc(String title) {
        this.id = nbDigitalVideoDisc + 1;
        nbDigitalVideoDisc++;
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, double cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, double cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this(title, category, director, cost);
        this.cost = cost;
        this.length = length;
    }
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public int getId() { return id; }

    public double getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * The function printDetail() prints out the title, category, director, length, and cost of a hust.soict.dsai.aims.disc.DigitalVideoDisc object
     */
    public void printDetail(){
        System.out.println("------ DigitalVideoDisc Detail ------");
        System.out.println(title + " " + " " + category + " " + director + " " + length + " " + cost);
    }

    /**
     * The function takes the information stored in the object and returns it as a string
     *
     * @return A string representation of the DVD object.
     */
    public String toString(){
        StringBuffer printDisc = new StringBuffer();
        printDisc.append("DVD");
        printDisc.append(" - ");
        printDisc.append(title);
        printDisc.append(" - ");
        printDisc.append(category);
        printDisc.append(" - ");
        printDisc.append(director);
        printDisc.append(" - ");
        printDisc.append(length);
        printDisc.append(": ");
        printDisc.append(cost);
        return  printDisc.toString();
    }

    /**
     * This function returns true if the title of the book is equal to the title passed in as a parameter.
     *
     * @param title The title of the page.
     * @return The boolean value of the comparison of the title of the book to the title of the book being searched for.
     */
    public boolean isMatch(String title){
        return this.title.equals(title);
    }
}
