package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public BookRepository() {
    }

    private List<Book> bookList = new ArrayList<>();
    private int id = 1;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book save(Book book){
        book.setId(id);
        bookList.add(book);
        id++;
        return book;
    }

    public Book findBookById(String id){
        for(Book book : bookList){
            if(book.getId()==Integer.parseInt(id))
                return book;
        }
        return null;
    }

    public List<Book> findAll(){

        return bookList;
    }

    public void deleteBookById(String id){
        for(int i=0;i<bookList.size();i++){
            if(bookList.get(i).getId()==Integer.parseInt(id)){
                bookList.remove(bookList.get(i));
            }
        }
    }

    public void deleteAll(){
        bookList.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author))
                list.add(book);
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(genre))
                list.add(book);
        }
        return list;
    }
}
