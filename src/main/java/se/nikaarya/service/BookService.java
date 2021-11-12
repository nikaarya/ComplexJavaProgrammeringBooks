package se.nikaarya.service;

import se.nikaarya.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BookService {

    @PersistenceContext
    EntityManager entityManager;

    public void createBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    public Book findBookById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    public void deleteBook(Long id) {
        Book foundBook = entityManager.find(Book.class, id);
        entityManager.remove(foundBook);
    }
}
