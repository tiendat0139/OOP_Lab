package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
    protected int length;
    protected String director;

    public Disc() {

    }
    public Disc(int id, String title, String category, double cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
