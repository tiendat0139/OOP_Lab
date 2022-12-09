package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    /**
     * If the author is already in the list, return false. Otherwise, add the author to the list and return true
     *
     * @param authorName The name of the author to add to the book.
     * @return A boolean value.
     */
    public boolean addAuthor(String authorName) {
        if(authors.contains(authorName)){
            return false;
        } else {
            authors.add(authorName);
            return true;
        }
    }

    /**
     * If the author is in the list, remove them and return true. Otherwise, return false
     *
     * @param authorName the name of the author to remove
     * @return A boolean value.
     */
    public boolean removeAuthor(String authorName) {
        if(authors.contains(authorName)){
            authors.remove(authorName);
            return true;
        } else {
            return false;
        }
    }

   @Override
    public String toString(){
        StringBuffer printBook = new StringBuffer();
        printBook.append(id);
        printBook.append(" - ");
        printBook.append("Book");
        printBook.append(" - ");
        printBook.append(title);
        printBook.append(" - ");
        printBook.append(category);
        printBook.append(": ");
        printBook.append(cost);
        return  printBook.toString();
    }

    @Override
    public boolean isMatch(String title){
        return this.title.equals(title);
    }
}
