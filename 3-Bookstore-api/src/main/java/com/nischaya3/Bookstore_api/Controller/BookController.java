package com.nischaya3.Bookstore_api.Controller;

import com.nischaya3.Bookstore_api.Entity.Book;
import com.nischaya3.Bookstore_api.Repository.BookRepository;
import com.nischaya3.Bookstore_api.Service.BookService;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.LongFunction;

@RestController
@RequestMapping("/api/books")

public class BookController {

    private BookService bookService;
    private BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){ // We need a body to post something
        Book createdBook = bookService.createBook(book); // req is sent in JSON format to database to be stored in java
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook); // 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        Book bookResp = bookService.getBook(id); // response is sent from database to client that object exists
        if (bookResp==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //404 not found so return null
        return ResponseEntity.ok(bookResp); // 200 return the body
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>>getAllBooks(){
        List<Book>booksResp = bookService.getAllBooks();
        if(booksResp==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(booksResp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book>updateBook(@RequestBody Book bookReq,@PathVariable Long id){
        Book bookResp = bookService.updateBook(bookReq,id); // We wish to update the old request
        if(bookResp!=null) return ResponseEntity.ok(bookResp);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteBook(@PathVariable Long id){
        boolean isDeleted = bookService.deleteBook(id);
        if(isDeleted) return ResponseEntity.ok("Book deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String>softDeleteBook(@PathVariable Long id){
        Boolean isDeleted = bookService.softDeleteBook(id);
        if(isDeleted) return ResponseEntity.ok("Book deleted softly");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book already softly deleted");
    }
}
