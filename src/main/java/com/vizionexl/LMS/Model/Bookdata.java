package com.vizionexl.LMS.Model;

import jakarta.persistence.*;

//table mapping done here
@Entity
@Table(name="books")

public class Bookdata{

    @Id
    @Column(name="id")
    private int id;

    @Column(name="book_name",length=100)
    private String bookName;

    @Column(name="author_name",length=100)
    private String authorName;

    @Column(name="year_of_publication")
    private int yearOfPublication;

    @Column(name="book_type",length=50)
    private String bookType;

    @Column(name="borrowed_status")
    private boolean borrowed_status=false;

    @ManyToOne
    @JoinColumn(name="borrowed_by_id",referencedColumnName = "user_id")
    private UserData borrowedBy;

    public boolean isBorrowed_status() {
        return borrowed_status;
    }

    public void setBorrowed_status(boolean borrowed_status) {
        this.borrowed_status = borrowed_status;
    }

    public UserData getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(UserData borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public Bookdata(){
    }

    public Bookdata(int id, String bookName, String authorName, int yearOfPublication, String bookType, boolean borrowed_status, UserData borrowedBy) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
        this.borrowed_status = borrowed_status;
        this.borrowedBy = borrowedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
