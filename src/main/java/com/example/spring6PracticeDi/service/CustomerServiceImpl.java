package com.example.spring6PracticeDi.service;

import com.example.spring6PracticeDi.model.Customer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  private final HashMap<UUID, Customer> customerList;

  public CustomerServiceImpl() {
    customerList = new HashMap<>();

    var customer1 = Customer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .name("Ishank")
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();

    var customer2 = Customer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .name("David")
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();

    var customer3 = Customer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .name("Chris")
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();

    customerList.put(customer1.getId(), customer1);
    customerList.put(customer2.getId(), customer2);
    customerList.put(customer3.getId(), customer3);
  }

  @Override
  public List<Customer> listAllCustomers() {
    return new ArrayList<>(customerList.values());
  }

  @Override
  public Customer getCustomerById(UUID id) {
    return customerList.get(id);
  }

  @Override
  public Customer addNewCustomer(Customer customer) {
    var savedCustomer = Customer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .name(customer.getName())
        .createDate(LocalDateTime.now())
        .updateDate(LocalDateTime.now())
        .build();
    customerList.put(savedCustomer.getId(), savedCustomer);
    return savedCustomer;
  }
}
