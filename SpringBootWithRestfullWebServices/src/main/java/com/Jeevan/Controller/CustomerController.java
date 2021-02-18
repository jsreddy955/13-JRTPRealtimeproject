package com.Jeevan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jeevan.Bean.Customer;
import com.Jeevan.Service.CustomerServiceImpl;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@GetMapping("/customers/")
	public List<Customer> getAllCustomer() {

		return customerServiceImpl.getAllCustomer();
	}

}
