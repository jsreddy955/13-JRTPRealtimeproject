package com.balaji.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.balaji.adminportal.model.Book;
import com.balaji.adminportal.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/book")
@Api(value = "onlineBookStore", description = "Operations pertaining to Books in Online Store")
public class BookController {
	@Autowired
	private BookService bookService;

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Iterable list() {
		Iterable bookList = bookService.findAll();
		return bookList;
	}

	@ApiOperation(value = "Search a Book with an ID", response = Book.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Book showProduct(@PathVariable Long id, Model model) {
		Book book = bookService.findOne(id);
		return book;
	}

	@ApiOperation(value = "Add a Book")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity saveProduct(@RequestBody Book book) {
		Book bookBean = bookService.save(book);

		try {
			byte[] imageByte=Base64.decodeBase64(book.getBookImage());
			String name = bookBean.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/book/" + name)));
			stream.write(imageByte);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity("Book saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update a Book")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateProduct(@RequestBody Book book) {
		bookService.save(book);
		return new ResponseEntity("Product updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a Book")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Long id) {
		bookService.removeOne(id);
		return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
	}

}
