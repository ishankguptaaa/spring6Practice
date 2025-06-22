package com.example.spring6PracticeDi.service;

import com.example.spring6PracticeDi.model.Beer;
import java.util.UUID;

public interface BeerService {

  Beer getBeerById(UUID id);

}
