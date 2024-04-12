package org.example;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionalService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public void saveAndTrace(Author a){
        authorRepository.save(a);
        print();
    }

    private static void print() {
        System.out.println("Author saved");
        throw new RuntimeException();
    }

}
