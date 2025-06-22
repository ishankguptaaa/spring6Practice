package com.example.spring6PracticeDi.service;

import com.example.spring6PracticeDi.model.Beer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

  private final HashMap<UUID,Beer> beerMap;

  public BeerServiceImpl() {
    beerMap = new HashMap<>();
    var bear1 = Beer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .beerName("Galaxy Cat")
        .upc("12356")
        .price(new BigDecimal("12.99"))
        .quantityOnHand(122)
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();

    var bear2 = Beer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .beerName("Uni Cat")
        .upc("123526")
        .price(new BigDecimal("13.99"))
        .quantityOnHand(100)
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();

    var bear3 = Beer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .beerName("Heto Cat")
        .upc("12456")
        .price(new BigDecimal("14.99"))
        .quantityOnHand(210)
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();

    beerMap.put(bear1.getId(), bear1);
    beerMap.put(bear2.getId(), bear2);
    beerMap.put(bear3.getId(), bear3);
  }

  @Override
  public Beer getBeerById(UUID id) {
    log.debug("Get Beer Id in service was called");
    return beerMap.get(id);
  }

  @Override
  public List<Beer> listBeers() {
    return new ArrayList<>(beerMap.values());
  }

  @Override
  public Beer saveNewBeer(Beer beer) {
    var newBeer= Beer.builder()
        .id(UUID.randomUUID())
        .version(1)
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .beerName(beer.getBeerName())
        .beerStyle(beer.getBeerStyle())
        .quantityOnHand(beer.getQuantityOnHand())
        .upc(beer.getUpc())
        .price(beer.getPrice())
        .build();
    beerMap.put(newBeer.getId(),newBeer);
    return newBeer;
  }

  @Override
  public void updateBeerById(UUID id, Beer beer) {
    var updatedBeer=beerMap.get(id);
    updatedBeer.setBeerName(beer.getBeerName());
    updatedBeer.setBeerStyle(beer.getBeerStyle());
    updatedBeer.setPrice(beer.getPrice());
    updatedBeer.setUpc(beer.getUpc());
    updatedBeer.setQuantityOnHand(beer.getQuantityOnHand());
    updatedBeer.setUpdatedDate(LocalDateTime.now());
    updatedBeer.setVersion(2);
    beerMap.put(id,updatedBeer);
  }
}
