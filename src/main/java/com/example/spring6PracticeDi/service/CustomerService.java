package com.example.spring6PracticeDi.service;

import com.example.spring6PracticeDi.model.Customer;
import java.util.List;
import java.util.UUID;

public interface CustomerService {

  List<Customer> listAllCustomers();
  Customer getCustomerById(UUID id);

  Customer addNewCustomer(Customer customer);
}
