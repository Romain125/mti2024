package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    BookJpaRepository bookJpaRepository;

    public BookService(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    public void loadInDB(Book b){
        bookJpaRepository.save(b);
    }
}
