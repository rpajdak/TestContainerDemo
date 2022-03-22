package com.example.demo.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableConfiguration {

  @Bean
  TableService tableService(TableRepository tableRepository) {
    return new TableService(tableRepository);
  }
}
