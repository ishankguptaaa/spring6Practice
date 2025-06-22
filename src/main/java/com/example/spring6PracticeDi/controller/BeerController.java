package com.example.spring6PracticeDi.controller;

import com.example.spring6PracticeDi.model.Beer;
import com.example.spring6PracticeDi.service.BeerService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
  private final BeerService beerService;

  @PutMapping("{beerId}")
  public ResponseEntity<String> updateById(@PathVariable("beerId") UUID id,@RequestBody Beer beer){
    beerService.updateBeerById(id,beer);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity handlePost(@RequestBody Beer beer){
    var savedBeer=beerService.saveNewBeer(beer);
    var headers=new HttpHeaders();
    headers.add("Location","api/v1/beer/"+savedBeer.getId().toString());
    return new ResponseEntity(headers,HttpStatus.CREATED);
  }

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
