package pl.ave.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.ave.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);

    }

    @Override
    @Transactional(readOnly = true)
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public void update(Book book) {
        Book find = entityManager.find(Book.class, book.getId());
        if(find != null){
            find.setTitle(book.getTitle());
            find.setIsbn(book.getIsbn());
            find.setAuthor(book.getAuthor());
        }
    }

    @Override
    @Transactional
    public void remove(Long book_id) {
        Book objToRemove = entityManager.find(Book.class, book_id);
        entityManager.remove(objToRemove);
        System.out.println(objToRemove.getId());

    }
}
