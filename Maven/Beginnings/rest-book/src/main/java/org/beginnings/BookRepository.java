package org.beginnings;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Book 001", "Author 001", 2012, "IT"),
                new Book(2, "Book 002", "Author 002", 2013, "IT"),
                new Book(3, "Book 003", "Author 003", 2014, "IT"),
                new Book(4, "Book 004", "Author 004", 2015, "IT")
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
