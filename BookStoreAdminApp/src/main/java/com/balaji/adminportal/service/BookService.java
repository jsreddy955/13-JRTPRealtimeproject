package com.balaji.adminportal.service;

import java.util.List;

import com.balaji.adminportal.model.Book;

public interface BookService {
	
	Book save(Book book);

	List<Book> findAll();
	
	Book findOne(Long id);
	
	void removeOne(Long id);
}
