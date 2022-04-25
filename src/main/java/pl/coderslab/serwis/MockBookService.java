package pl.coderslab.serwis;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBookService {
    private final List<Book> list;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getAll(){
        return list;
    }

    public Book getById(long id){
        Book book = new Book();
        return list.stream()
                .filter(b -> b.getId()==id)
                .findAny().orElseGet(() -> book);
    }

    public void add(Book book){
        list.add(book);
    }

    public void delete(long id){
        list.remove(getById(id));
    }

    public void edit(Book book){
        delete(book.getId());
        list.add(book);
    }




}
