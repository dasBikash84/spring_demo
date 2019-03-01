package com.dasbikash.springguru101.services;

import com.dasbikash.springguru101.model.Author;
import com.dasbikash.springguru101.repositories.AuthorRepository;
import com.dasbikash.springguru101.servicedef.AuthorService;
import org.springframework.stereotype.Service;

@Service()
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
