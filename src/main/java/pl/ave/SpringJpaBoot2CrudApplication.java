package pl.ave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import pl.ave.dao.BookDao;
import pl.ave.model.Book;

@SpringBootApplication
public class SpringJpaBoot2CrudApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringJpaBoot2CrudApplication.class, args);

        // CREATE
        BookDao dao = ctx.getBean(BookDao.class);
        Book book = new Book("1234567890468", "Spring is so cool", "Javack");
        dao.save(book);

        // UPDATE
        Book book2 = new Book("987654321", "Java super sprawa", "Ave");
        book2.setId(1L);
        dao.update(book2);

        // READ
        Book findBook = dao.get(1L);
        System.out.println(findBook);

        // DELETE
        dao.remove(1L);
        Book book3 = dao.get(1L);
        System.out.println(book3); //null


    }
}
