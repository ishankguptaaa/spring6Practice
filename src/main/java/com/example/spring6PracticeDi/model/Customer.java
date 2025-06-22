package com.example.spring6PracticeDi.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

  private UUID id;
  private String name;
  private Integer version;
  private LocalDateTime createDate;
  private LocalDateTime updateDate;
}
