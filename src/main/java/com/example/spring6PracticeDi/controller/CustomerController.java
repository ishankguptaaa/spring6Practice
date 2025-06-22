package com.example.spring6PracticeDi.controller;

import com.example.spring6PracticeDi.model.Customer;
import com.example.spring6PracticeDi.service.CustomerService;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping
  public ResponseEntity<String> addNewCustomer(@RequestBody Customer customer){
    var newCustomer=customerService.addNewCustomer(customer);
    var headers= new HttpHeaders();
    headers.add("Location","/api/v1/customer/"+newCustomer.getId().toString());
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
  }

  @GetMapping
  public List<Customer> listAllCustomer(){
    return customerService.listAllCustomers();
  }

  @GetMapping("{customerId}")
  public Customer getCustomerById(@PathVariable("customerId") UUID id){
    return customerService.getCustomerById(id);
  }

}
