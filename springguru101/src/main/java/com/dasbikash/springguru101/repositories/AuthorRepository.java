package com.dasbikash.springguru101.repositories;

import com.dasbikash.springguru101.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
