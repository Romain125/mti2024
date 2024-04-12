package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);
        AuthorRepository repository = context.getBean(AuthorRepository.class);
        TransactionalService service = context.getBean(TransactionalService.class);

        System.out.println("################################################");
        System.out.println("################################################");
        try {
            service.saveAndTrace(new Author("JKRowling"));
        } catch (Exception e){
            //...
        }
        System.out.println(repository.count());
        System.out.println("################################################");
        System.out.println("################################################");

//        Author jkr = new Author("JKRowling");
//        AuthorRepository authorRepo = context.getBean(AuthorRepository.class);
//        authorRepo.save(jkr);
//        Book b1 = new Book(new Title("Harry Potter 1", "Le Harry Potter 1"), Set.of(jkr), BookType.AVENTURE);
//        Book b2 = new Book(new Title("Harry Potter 2", "Le Harry Potter 2"), Set.of(jkr), BookType.AVENTURE);
//        Book b3 = new Book(new Title("Harry Potter 3", "Le Harry Potter 3"), Set.of(jkr), BookType.AVENTURE);
//        Book b4 = new Book(new Title("Harry Potter 4", "Le Harry Potter 4"), Set.of(jkr), BookType.AVENTURE);
//        Book b5 = new Book(new Title("Harry Potter 5", "Le Harry Potter 5"), Set.of(jkr), BookType.LOVE);
//        repo.save(b1);
//        repo.save(b2);
//        repo.save(b3);
//        repo.save(b4);
//        repo.save(b5);
//        System.out.println(repo.findAll());
//        System.out.println(repo.findBookByType(BookType.LOVE));
//        System.out.println(repo.findTop3BookByTypeOrderByIdDesc(BookType.AVENTURE));
//        System.out.println(repo.findFirstByTitle_OriginalNameContaining("4"));
    }
}