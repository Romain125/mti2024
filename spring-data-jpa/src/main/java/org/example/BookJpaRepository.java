package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByType(BookType type);
    List<Book> findTop3BookByTypeOrderByIdDesc(BookType bookType);
    Book findFirstByTitle_OriginalNameContaining(String partOfTitle);
}
