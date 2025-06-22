package com.example.spring6PracticeDi.service;

import com.example.spring6PracticeDi.model.Beer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public Beer getBeerById(UUID id) {
    log.debug("Get Beer Id in service was called");
    return Beer.builder()
        .id(id)
        .version(1)
        .beerName("Galaxy Cat")
        .upc("12356")
        .price(new BigDecimal("12.99"))
        .quantityOnHand(122)
        .createdDate(LocalDateTime.now())
        .updatedDate(LocalDateTime.now())
        .build();
  }
}
