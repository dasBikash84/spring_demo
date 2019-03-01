package com.dasbikash.springguru101.controllers;

import com.dasbikash.springguru101.repositories.AuthorRepository;
import com.dasbikash.springguru101.servicedef.AuthorService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    //@Autowired
    /*private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository=authorRepository;
    }*/

    /*@Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }*/

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("authors")
    public String getAuthors(Model model){

        model.addAttribute("authors",authorService.getAllAuthors());
        return "dir1/authors";
    }
}
