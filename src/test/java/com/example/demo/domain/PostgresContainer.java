package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;

import java.util.Map;

import static org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils.randomAlphabetic;
import static org.testcontainers.shaded.org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PostgresContainer {

  private static final MySQLContainer<?> CONTAINER;

  static {
    CONTAINER = new MySQLContainer<>("mysql:"
        + System.getProperty("server", "latest"))
        .withDatabaseName("test_db_" + randomAlphabetic(6))
        .withUsername("user_" + randomAlphabetic(6))
        .withPassword(randomAlphanumeric(12))
        .withTmpFs(Map.of("/var/lib/mysql", "rw"));

    CONTAINER.start();
  }

  public static String getJdbcUrl() {
    return CONTAINER.getJdbcUrl();
  }

  public static String getUsername() {
    return CONTAINER.getUsername();
  }

  public static String getPassword() {
    return CONTAINER.getPassword();
  }

  public static String getDriverClassName() {
    return CONTAINER.getDriverClassName();
  }

  public static class PostgresTestInitializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
      TestPropertyValues propertyValues = TestPropertyValues.of(
          "spring.datasource.url=" + getJdbcUrl(),
          "spring.datasource.username=" + getUsername(),
          "spring.datasource.password=" + getPassword(),
          "spring.datasource.driver-class-name=" + getDriverClassName(),
          "spring.test.database.replace=none"
      );
      propertyValues.applyTo(context.getEnvironment());
    }
  }
}
