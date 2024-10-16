package org.example.springdata.person;

import org.example.springdata.person.projection.NamesOnly;
import org.springframework.data.domain.PageRequest;
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
}