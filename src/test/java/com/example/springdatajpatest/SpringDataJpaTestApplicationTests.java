package com.example.springdatajpatest;

import com.example.springdatajpatest.sqldatabase.Customer;
import com.example.springdatajpatest.sqldatabase.CustomerRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringDataJpaTestApplicationTests {

    @Autowired
    private CustomerRepository repository;

    @Test
    void contextLoads() {
    }


    @Test
    @Order(1)
    void canCustomerBeAdded() {
        Customer customer = repository.save(new Customer("Fynn", "Juranek"));
        Assertions.assertNotNull(customer);
    }

    @Test
    @Order(2)
    void canCustomerBeFound() {
        Customer customer = repository.findByLastName("Juranek").get(0);
        System.out.println("Found customer: " + customer.getFirstName());
        Assertions.assertNotNull(customer);
    }

    @Test
    @Order(3)
    void canCustomerBeDeleted() {
        repository.delete(repository.findByLastName("Juranek").get(0));
        Assertions.assertTrue(repository.findByLastName("Juranek").isEmpty());
    }

}
