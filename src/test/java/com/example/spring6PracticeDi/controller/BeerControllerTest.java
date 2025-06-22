package com.example.spring6PracticeDi.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerControllerTest {

  @Autowired
  BeerController beerController;

  @Test
  void getBeerById() {
    System.out.println(beerController.getBeerById(UUID.randomUUID()));
  }
}