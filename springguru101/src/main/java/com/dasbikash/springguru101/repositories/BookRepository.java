package com.dasbikash.springguru101.repositories;

import com.dasbikash.springguru101.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
