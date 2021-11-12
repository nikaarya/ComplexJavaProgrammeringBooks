package se.nikaarya.rest;

import jakarta.inject.Inject;
import se.nikaarya.entity.Book;
import se.nikaarya.service.BookService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookRest {

    @Inject
    BookService bookService;

    @Path("create")
    @POST
    public Response createBook(Book book) {
        bookService.createBook(book);
        return Response.ok(book).build();
    }

    @Path("update")
    @PUT
    public Response updateBook(Book book) {
        bookService.updateBook(book);
        return Response.ok(book).build();
    }

    @Path("{id}")
    @GET
    public Response getBook(@PathParam("id") Long id) {
        Book foundBook = bookService.findBookById(id);
        return Response.ok(foundBook).build();
    }
    @Path("getall")
    @GET
    public Response getAllBooks() {
        List<Book> foundBooks = bookService.getAllBooks();
        return Response.ok(foundBooks).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteBook(@PathParam("id") Long id) {
        bookService.deleteBook(id);
        return Response.ok().build();
    }
}
