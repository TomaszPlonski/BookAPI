package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.serwis.MockBookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService mockBookService;

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("")
    public List<Book> getAllBooks(){
        return mockBookService.getAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id){
        return mockBookService.getById(id);
    }

    @PostMapping("")
    public void addBook(@RequestParam Book book){
        mockBookService.add(book);

    }


}
