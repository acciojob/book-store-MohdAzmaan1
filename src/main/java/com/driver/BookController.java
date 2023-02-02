package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") String id){
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
    }

    @GetMapping("/get-all-books")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

    @DeleteMapping("/delete-all-books")
    public void deleteAllBooks(){
        bookService.deleteAllBooks();
    }

    @GetMapping("/get-books-by-author")
    public List<Book> findBooksByAuthor(@RequestParam("name") String author){
        return bookService.findBooksByAuthor(author);
    }

    @GetMapping("/get-books-by-genre")
    public List<Book> findBooksByGenre(@RequestParam("name") String genre){
        return bookService.findBooksByGenre(genre);
    }
}
