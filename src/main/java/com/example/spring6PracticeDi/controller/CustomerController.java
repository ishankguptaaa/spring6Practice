package com.example.spring6PracticeDi.controller;

import com.example.spring6PracticeDi.model.Customer;
import com.example.spring6PracticeDi.service.CustomerService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public List<Customer> listAllCustomer(){
    return customerService.listAllCustomers();
  }

  @GetMapping("{customerId}")
  public Customer getCustomerById(@PathVariable("customerId") UUID id){
    return customerService.getCustomerById(id);
  }

}
