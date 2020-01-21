package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    
    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }        

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {            
            
            System.out.println("\nAdd author with books ...");
            bookstoreService.addAuthorWithBooks();
            
            System.out.println("\nFetch author by name ...");
            bookstoreService.fetchAuthorByName();

            System.out.println("\nRemove a book of an author ...");
            bookstoreService.removeBookOfAuthor();
            
            System.out.println("\nRemove author (and books via cascade) ...");
            bookstoreService.removeAuthor();
        };
    }
}

/*
 * How To Define A Composite Primary Key Via @IdClass

Description: This application is a proof of concept of how to define a composite key via @IdClass. This application uses two entities, Author and Book involved in a lazy bidirectional @OneToMany association. The identifier of Author is composed by name and age via AuthorId class. The identifier of Book is just a typical auto-generated numeric value.

Key points:

the composite key class (e.g., AuthorId) is public
the composite key class must implement Serializable
the composite key must define equals() and hashCode()
the composite key must define a no-arguments constructor
Note: The @IdClass can be useful when we cannot modify the compsite key class. Otherwise, rely on @Embeddable.
 * 
 */
