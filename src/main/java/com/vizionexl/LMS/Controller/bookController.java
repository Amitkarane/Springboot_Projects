package com.vizionexl.LMS.Controller;


import com.vizionexl.LMS.Model.Bookdata;
import com.vizionexl.LMS.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookController {

    @Autowired
    private BookService bookService;

//    this is used to check the status of the Application
    @GetMapping("/check")
    public String Check(){
        return "book Controller is Running";
    }

//    this is used to get OR TO read all the books
    @GetMapping
    public List<Bookdata> getAllBooks(){
        return bookService.getBooks();
    }

//    this is used to save the book in Library
    @PostMapping
    public Bookdata saveBook(@RequestBody Bookdata book){
        return bookService.saveBook(book);
    }

//    this is used to delete the book by id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){ //PathVariable- Path(URL) Variable( Value )
        return bookService.deleteBook(id);
    }

//    this is used to update the book
    @PatchMapping("/{id}")
    public Bookdata updateBook(@PathVariable int id, @RequestBody Bookdata book){
        return bookService.updateBook(id,book);
    }

//    this is used to borrow the book by book id and user id
    @PatchMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Bookdata> BorrowBook(@PathVariable int bookId, @PathVariable Long userId){
        Bookdata BorrowedBook = bookService.borrowBook(bookId,userId);
        if(BorrowedBook!=null){
            return ResponseEntity.ok(BorrowedBook);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }

//    this is used to return the borrowed book using book id
    @PatchMapping("/{bookId}/return")
    public ResponseEntity<Bookdata> ReturnBook(@PathVariable int bookId){
        Bookdata ReturnedBook = bookService.ReturnBook(bookId);
        if(ReturnedBook!=null){
            return ResponseEntity.ok(ReturnedBook);
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
}
