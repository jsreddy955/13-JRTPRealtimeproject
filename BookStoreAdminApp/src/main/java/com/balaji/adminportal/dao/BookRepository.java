package com.balaji.adminportal.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.balaji.adminportal.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    public List<Book> findByAuthor(String author);
}
