package ru.netology.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.netology.money.domain.Confirmation;
import ru.netology.money.domain.Transfer;

import java.util.HashMap;
import java.util.Map;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private static final GenericContainer<?> myApp = new GenericContainer<>("money:latest").withExposedPorts(5500);

    @BeforeAll
    public static void setUp() {
    }

    @Test
    void contextLoads() {

    }

    @Test
    void getTransferResponseTest() {

        Transfer transfer = new Transfer();
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + myApp.getMappedPort(5500) + "/transfer", transfer, String.class);
        Assertions.assertNotNull(response);

    }

    @Test
    void getConfirmationOperationResponseTest() {
        Confirmation confirmation = new Confirmation();
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + myApp.getMappedPort(5500) + "/confirmOperation", confirmation, String.class);
        Assertions.assertNotNull(response);
    }

    @Test
    void getConfirmOperationDataTest() {
        Confirmation confirmation = new Confirmation("1", "0000");
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + myApp.getMappedPort(5500) + "/confirmOperation", confirmation, String.class);
        String operationId = "{\"operationId\":\"" + confirmation.getOperationId() + "\"}";
        Assertions.assertEquals(response.getBody(), operationId);

    }

}
