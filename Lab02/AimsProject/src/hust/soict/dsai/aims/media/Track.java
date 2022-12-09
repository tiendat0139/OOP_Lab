package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean equals(Track o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Track)){
            return false;
        }
        Track t = (Track) o;
        return title == t.getTitle() && length == t.getLength();
    }
}
