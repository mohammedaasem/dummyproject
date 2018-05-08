package com.aasem.inspire_info_soft.myschool.DataClasses;

/**
 * Created by inspire_info_soft on 2/14/2018.
 */

public class HomeLabrory {
    String bookName,bookAuthorName,bookPublicationName,bookReleaseYear,bookAvailable;

    public HomeLabrory(String bookName, String bookAuthorName, String bookPublicationName, String bookReleaseYear, String bookAvailable) {
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
        this.bookPublicationName = bookPublicationName;
        this.bookReleaseYear = bookReleaseYear;
        this.bookAvailable = bookAvailable;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public String getBookPublicationName() {
        return bookPublicationName;
    }

    public void setBookPublicationName(String bookPublicationName) {
        this.bookPublicationName = bookPublicationName;
    }

    public String getBookReleaseYear() {
        return bookReleaseYear;
    }

    public void setBookReleaseYear(String bookReleaseYear) {
        this.bookReleaseYear = bookReleaseYear;
    }

    public String getBookAvailable() {
        return bookAvailable;
    }

    public void setBookAvailable(String bookAvailable) {
        this.bookAvailable = bookAvailable;
    }
}
