package com.vizionexl.LMS.Service;


import com.vizionexl.LMS.DAO.UserRepository;
import com.vizionexl.LMS.DAO.bookRepository;
import com.vizionexl.LMS.Model.Bookdata;
import com.vizionexl.LMS.Model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private bookRepository bookRepository;

    @Autowired
    private UserRepository userrepository;

    public List<Bookdata> getBooks(){
        return bookRepository.findAll();
    }

    public Bookdata saveBook(Bookdata book){
        return bookRepository.save(book);
    }

    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "The book with the id " + id + " is deleted.";
    }

    public Bookdata updateBook(int id, Bookdata book){
        Optional<Bookdata> bookoptional= bookRepository.findById(id);
        Bookdata savedBook=bookoptional.get();

        if(book.getBookName()!=null)
            savedBook.setBookName(book.getBookName());

        return bookRepository.save(savedBook);
    }

    public Bookdata borrowBook(int bookId, Long userId) {
        Bookdata book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        UserData user = userrepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        book.setBorrowedBy(user);
        book.setBorrowed_status(true);

        return bookRepository.save(book);
    }

    public Bookdata ReturnBook(int book_id){
        Bookdata book = bookRepository.findById(book_id).orElseThrow(()->new RuntimeException("Book not Found"));
        if(book!=null && book.isBorrowed_status()){
            book.setBorrowedBy(null);
            book.setBorrowed_status(false);
            return saveBook(book);
        }
        else{
            return null;
        }
    }
}
