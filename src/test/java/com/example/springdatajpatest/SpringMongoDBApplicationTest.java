package com.example.springdatajpatest;

import com.example.springdatajpatest.nosqldatabase.Person;
import com.example.springdatajpatest.nosqldatabase.PersonRepository;
import com.example.springdatajpatest.sqldatabase.Customer;
import com.example.springdatajpatest.sqldatabase.CustomerRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringMongoDBApplicationTest {
    @Autowired
    private PersonRepository repository;

    @Test
    void contextLoads() {
    }


    @Test
    @Order(1)
    void canPersonBeAdded() {
        Person person = repository.save(new Person("Fynn", "Juranek"));
        Assertions.assertNotNull(person);
    }

    @Test
    @Order(2)
    void canPersonBeFound() {
        Person person = repository.findByLastName("Juranek").get(0);
        System.out.println("Found customer: " + person.toString());
        Assertions.assertNotNull(person);
    }

    @Test
    @Order(3)
    void canPersonBeDeleted() {
        repository.delete(repository.findByLastName("Juranek").get(0));
        Assertions.assertTrue(repository.findByLastName("Juranek").isEmpty());
    }

}
