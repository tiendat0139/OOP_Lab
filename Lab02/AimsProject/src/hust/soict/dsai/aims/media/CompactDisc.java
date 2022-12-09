package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String artist, List<Track> tracks) {
        this.artist = artist;
        this.tracks = tracks;
    }

    public boolean addTrack(Track newTrack) {
        if(tracks.contains(newTrack)){
            return false;
        } else {
            tracks.add(newTrack);
            return true;
        }
    }

    public boolean remoteTrack(Track track) {
        if(tracks.contains(track)){
            tracks.remove(track);
            return true;
        } else {
            return false;
        }
    }

    public int getLength(){
        int result = 0;
        for (Track track : tracks){
            result += track.getLength();
        }
        return result;
    }


    @Override
    public void play() {
        System.out.println("Artist: " + artist);
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
}
