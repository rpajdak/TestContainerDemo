package com.example.demo.domain;

import org.springframework.data.repository.Repository;

interface TableRepository extends Repository<Table, Long> {

  Table save(Table table);

  Table getById(Long id);
}
