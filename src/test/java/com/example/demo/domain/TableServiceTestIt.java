package com.example.demo.domain;

import com.example.demo.domain.PostgresContainer.PostgresTestInitializer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = TableConfiguration.class)
@AutoConfigurationPackage
@ContextConfiguration(initializers = {
    PostgresTestInitializer.class
})
@AutoConfigureDataJpa
@Transactional
class TableServiceTestIt {


  @Autowired
  private TableRepository tableRepository;

  @Autowired
  private TableService tableService;

  @Test
  void test() {
    //given
    Table table = new Table("testowy-user");
    tableRepository.save(table);

    //when
    Table table1 = tableService.getTable(1L);

    //then

    assertThat(table.getUploaderName()).isEqualTo("testowy-user");
  }
}
