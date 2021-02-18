package com.Jeevan.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.Jeevan.Bean.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {
	private static List<Customer> customers = new ArrayList<>();

	static {
		Customer jack1 = new Customer(1, "Jack Rutorial 1", "admin@jackrutorial.com", "This is a Jack 1");
		Customer jack2 = new Customer(2, "Jack Rutorial 2", "support@jackrutorial.com", "This is a Jack 2");
		Customer jack3 = new Customer(3, "Jack Rutorial 3", "test@jackrutorial.com", "This is a Jack 3");

		customers.add(jack1);
		customers.add(jack2);
		customers.add(jack3);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Random random = new Random();
		int nextid = random.nextInt(1000) + 10;
		customer.setId(nextid);
		customers.add(customer);

		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub

	}

}
