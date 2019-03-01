package com.dasbikash.springguru101.bootstrap;


import com.dasbikash.springguru101.model.Author;
import com.dasbikash.springguru101.model.Book;
import com.dasbikash.springguru101.model.Publisher;
import com.dasbikash.springguru101.repositories.AuthorRepository;
import com.dasbikash.springguru101.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234");
        Publisher publisher1 = new Publisher("Harper Collins","Address 1");
        ddd.setPublisher(publisher1);
        //eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        Publisher publisher2 = new Publisher( "Wrox","Address 2" );
        noEJB.setPublisher(publisher2);
        //rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        //authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}