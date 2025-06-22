package com.example.spring6PracticeDi.controller;

import com.example.spring6PracticeDi.model.Beer;
import com.example.spring6PracticeDi.service.BeerService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
  private final BeerService beerService;

  public Beer getBeerById(UUID id){
    log.debug("Get beer by id - in controller");
    return beerService.getBeerById(id);
  }

}
