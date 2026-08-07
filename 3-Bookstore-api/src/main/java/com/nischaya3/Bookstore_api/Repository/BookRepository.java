package com.nischaya3.Bookstore_api.Repository;

import com.nischaya3.Bookstore_api.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    public Optional<Book> getByIdAndDeletedIsFalse(Long id);
    public List<Book>getByDeletedIsFalse();
}
