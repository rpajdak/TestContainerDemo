package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
class TableService {

  @NonNull
  private final TableRepository tableRepository;

  Table getTable(Long id) {
    return tableRepository.getById(id);
  }
}
