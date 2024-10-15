package org.example.springdata.person;

import org.example.springdata.person.projection.NamesOnly;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Get all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    // Get person by ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.findById(id);
        return person.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new person
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = personService.save(person);
        return ResponseEntity.ok(savedPerson);
    }

    // Update a person
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Optional<Person> existingPerson = personService.findById(id);
        if (existingPerson.isPresent()) {
            updatedPerson.setId(id);
            personService.save(updatedPerson);
            return ResponseEntity.ok(updatedPerson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a person by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        Optional<Person> existingPerson = personService.findById(id);
        if (existingPerson.isPresent()) {
            personService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Stream all persons with pagination
    @GetMapping("/paged")
    public List<Person> getPagedPersons(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size) {
        try (Stream<Person> persons = personService.streamAllPersonsPaged(page, size)) {
            return persons.collect(Collectors.toList());
        }
    }

    // Get persons by last name
    @GetMapping("/by-lastname")
    public ResponseEntity<Collection<NamesOnly>> getPersonsByLastName(@RequestParam("lastname") String lastName) {
        Collection<NamesOnly> persons = personService.getPersonsByLastName(lastName);
        if (persons.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(persons);
    }
}