package org.example.springdata.system;

import org.example.springdata.person.Person;
import org.example.springdata.person.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {

    private final PersonRepository personRepository;

    public DBDataInitializer(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person("jane", "Doe", 30, "123 Main Street");
        Person p2 = new Person("John", "Doe", 30, "123 Main Street");
        Person p3 = new Person("Tony", "Stark", 30, "123 Main Street");

        personRepository.save(p1);
        personRepository.save(p2);
        personRepository.save(p3);
    }
}