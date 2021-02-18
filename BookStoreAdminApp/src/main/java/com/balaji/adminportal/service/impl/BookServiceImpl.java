package com.balaji.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.balaji.adminportal.dao.BookRepository;
import com.balaji.adminportal.model.Book;
import com.balaji.adminportal.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> findAll() {
		return (List<Book>) bookRepository.findAll();
	}
	
	public Book findOne(Long id) {
		return bookRepository.findOne(id);
	}
	
	public void removeOne(Long id) {
		bookRepository.delete(id);
	}
}
