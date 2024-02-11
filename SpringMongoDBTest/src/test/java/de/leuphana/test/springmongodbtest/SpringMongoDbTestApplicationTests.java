package de.leuphana.test.springmongodbtest;

import de.leuphana.test.springmongodbtest.database.Person;
import de.leuphana.test.springmongodbtest.database.PersonRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMongoDbTestApplicationTests {

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
		Person person = repository.findByLastName("Juranek").get(0);
		repository.delete(person);
		Assertions.assertTrue(repository.findByLastName("Juranek").isEmpty());
	}

}


