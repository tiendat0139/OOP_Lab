package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    /**
     * This function returns an ArrayList of Media objects that are currently in the store
     *
     * @return An ArrayList of Media objects
     */
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    /**
     * This function adds a media item to the store
     *
     * @param m The media object to be added to the store.
     * @return A boolean value.
     */
    public boolean addMedia(Media m){
        return itemsInStore.add(m);
    }

    /**
     * If the media is in the store, remove it and return true, otherwise return false
     *
     * @param m The media object to be removed from the store.
     * @return A boolean value.
     */
    public boolean removeMedia(Media m) {
        if (itemsInStore.contains(m)) {
            itemsInStore.remove(m);
            return true;
        } else {
            return false;
        }
    }

    /**
     * For each Media object in the itemsInStore array, call the toString() method on it.
     */
    public void displayStore() {
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }
    public Media searchInStore(String title) {
        for (Media m: itemsInStore){
            if(m.isMatch(title)){
                return m;
            }
        }
        return null;
    }
}
