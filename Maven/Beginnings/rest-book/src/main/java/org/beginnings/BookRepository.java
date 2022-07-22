package org.beginnings;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    // @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "Book 001", "Author 001", 2012, genre),
                new Book(2, "Book 002", "Author 002", 2013, genre),
                new Book(3, "Book 003", "Author 003", 2014, genre),
                new Book(4, "Book 004", "Author 004", 2015, genre)
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}
