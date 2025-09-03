package com.vizionexl.LMS.Controller;


import com.vizionexl.LMS.Model.Bookdata;
import com.vizionexl.LMS.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/check")
    public String Check(){
        return "book Controller is Running";
    }

    @GetMapping
    public List<Bookdata> getAllBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public Bookdata saveBook(@RequestBody Bookdata book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){ //PathVariable- Path(URL) Variable( Value )
        return bookService.deleteBook(id);
    }

    @PatchMapping("/{id}")
    public Bookdata updateBook(@PathVariable int id, @RequestBody Bookdata book){
        return bookService.updateBook(id,book);
    }
}
