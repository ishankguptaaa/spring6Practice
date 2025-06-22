package com.example.spring6PracticeDi.controller;

import com.example.spring6PracticeDi.model.Beer;
import com.example.spring6PracticeDi.service.BeerService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
  private final BeerService beerService;

  @GetMapping
  public List<Beer> listBeers(){
    return beerService.listBeers();
  }

  @GetMapping("/{beerId}")
  public Beer getBeerById(@PathVariable("beerId") UUID beerId){
    log.debug("Get beer by id - in controller");
    return beerService.getBeerById(beerId);
  }

}
