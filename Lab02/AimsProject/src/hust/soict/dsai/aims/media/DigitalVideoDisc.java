package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title) {
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

    public DigitalVideoDisc(int id, String title, String category, double cost, int length, String director) {
       super(id, title, category, cost, length, director);
    }


    /**
     * The function printDetail() prints out the title, category, director, length,
     * and cost of a hust.soict.dsai.aims.media.DigitalVideoDisc object
     */
    public void printDetail(){
        System.out.println("------ DigitalVideoDisc Detail ------");
        System.out.println(title + " " + " " + category + " " + director + " " + length + " " + cost);
    }

    @Override
    public String toString(){
        StringBuffer printDisc = new StringBuffer();
        printDisc.append(id);
        printDisc.append(" - ");
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

    @Override
    public boolean isMatch(String title){
        return this.title.equals(title);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
