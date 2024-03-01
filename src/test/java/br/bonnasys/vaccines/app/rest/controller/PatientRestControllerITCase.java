package br.bonnasys.vaccines.app.rest.controller;

import br.bonnasys.vaccines.support.annotation.E2ETest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

@E2ETest
@Testcontainers
class PatientRestControllerITCase {

    @Container
    private static final MySQLContainer<?> MYSQL_CONTAINER = new MySQLContainer<>("mysql:8.0.32")
            .withUsername("root")
            .withPassword("Luis@mysql123")
            .withDatabaseName("vaccines");

    @DynamicPropertySource
    private static void setDatasourceProperties(final DynamicPropertyRegistry registry) {
        registry.add("mysql.port", () -> MYSQL_CONTAINER.getMappedPort(3306));
    }

    @Test
    void dummy() {
        Assertions.assertTrue(MYSQL_CONTAINER.isRunning());
    }


}