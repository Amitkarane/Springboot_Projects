package com.vizionexl.LMS.Service;


import com.vizionexl.LMS.DAO.bookRepository;
import com.vizionexl.LMS.Model.Bookdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private bookRepository bookRepository;

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


}
