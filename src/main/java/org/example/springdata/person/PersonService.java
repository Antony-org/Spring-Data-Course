package org.example.springdata.person;

import org.example.springdata.person.projection.NamesOnly;
import org.example.springdata.person.repos.PersonSpecs;
import org.example.springdata.person.repos.Specifications;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Stream<Person> streamAllPersonsPaged(int page, int size) {
        return personRepository.streamAllPaged(PageRequest.of(page, size));
    }

    public Collection<NamesOnly> getPersonsByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public Collection<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Person> getPersonsByFirstname(String firstName) {
        return personRepository.getPersonByFirstname(firstName);
    }

    public List<Person> getPersonsByAge(int age) {
        return personRepository.getPersonByAge(age);
    }
}