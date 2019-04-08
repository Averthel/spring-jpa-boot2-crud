package pl.ave.dao;

import pl.ave.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(Long id);
    public void update(Book book);
    public void remove(Long book_id);
}
