package com.nischaya3.Bookstore_api.Service;

import com.nischaya3.Bookstore_api.Entity.Book;
import com.nischaya3.Bookstore_api.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book bookReq){
        bookReq.setDeleted(false); // For soft delete
        Book bookResp = bookRepository.save(bookReq); // response has been saved to repo
        return bookResp; // request has been created
    }

    public Book getBook(Long id){
        Optional<Book> bookResp = bookRepository.getByIdAndDeletedIsFalse(id); // Optional as book record may or may not exist
        if(bookResp.isPresent()) return bookResp.get(); // Optional class extracts the book class if anything is present
        return null;
    }

    public List<Book>getAllBooks(){
        List<Book>booksResp = bookRepository.getByDeletedIsFalse();
        return booksResp;
    }

    public Book updateBook(Book bookReq,Long id){
        Optional<Book>existingBook = bookRepository.getByIdAndDeletedIsFalse(id);
        if(existingBook.isPresent()){ // If there is an existing book update it
            Book bookToSave = existingBook.get(); // get all existing parameters
            bookToSave.setAuthor(bookReq.getAuthor()); // bookReq consists of updated body
            bookToSave.setPrice(bookReq.getPrice());
            bookToSave.setTitle(bookReq.getTitle());
            bookToSave.setDeleted(false); // keep soft deleted false even if someone updates it
            bookRepository.save(bookToSave); // Save in db
            return bookToSave;
        }
        return null;
    }

    public boolean deleteBook(Long id){
        boolean isBook = bookRepository.existsById(id);
        if(isBook){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean softDeleteBook(Long id){
        Optional<Book>bookToDelete = bookRepository.getByIdAndDeletedIsFalse(id);
        if(bookToDelete.isPresent()){
            Book bookToSave = bookToDelete.get();
            bookToSave.setDeleted(true); // Marked as soft deleted
            bookRepository.save(bookToSave); // We dont truly delete that record we just mark it as soft deleted
            return true;
        }
        return false;
    }
}
