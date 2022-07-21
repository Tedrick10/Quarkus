package org.beginnings;

import io.quarkus.logging.Log;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookRepository bookRepository;

    @GET
    public List<Book> getAllBooks() {
        Log.info("Return all of the books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        Log.info("Return the number of books");
        return bookRepository.countAllBooks();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getABook(@PathParam("id") int id) {
        Log.info("Return the book that matches with id: " + id);
        return bookRepository.getBook(id);
    }
}
