package com.dasbikash.springguru101.repositories;


import com.dasbikash.springguru101.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
