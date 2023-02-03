package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/books/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity getBook(@PathVariable("id") String id){
        Book newbook = bookService.findBookById(id);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-all-books")
    public ResponseEntity getAllBooks(){
        List<Book> newbook = bookService.findAllBooks();
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-books-by-author")
    public ResponseEntity getBookByAuthor(@RequestParam("author") String author){
        List<Book> newbook = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-books-by-genre")
    public ResponseEntity getBookByGenre(@RequestParam("genre") String genre){
        List<Book> newbook = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return  new ResponseEntity<>("success ", HttpStatus.FOUND);
    }

    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success ", HttpStatus.FOUND);
    }
}