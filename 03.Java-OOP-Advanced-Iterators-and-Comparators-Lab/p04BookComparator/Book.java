package p04BookComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private Integer year;
    private List<String> authors;

    public Book(String title, Integer year, String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
    }

    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return this.year;
    }

    private void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return Collections.unmodifiableList(this.authors);
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.asList(authors);
    }

    @Override
    public int compareTo(Book book) {
        if (this.getTitle().compareTo(book.getTitle()) == 0) {
            if (this.getYear() > book.getYear()) {
                return 1;
            } else if (this.getYear() < book.getYear()) {
                return -1;
            }
            return 0;
        } else {
            return this.getTitle().compareTo(book.getTitle());
        }
    }

    @Override
    public String toString() {
        return this.getTitle() + " " + this.getYear();
    }
}
