package org.example.springdata.person;

import org.example.springdata.person.projection.NamesOnly;
import org.example.springdata.person.repos.CustomPersonRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person, Long>, CustomPersonRepo {

    Stream<Person> streamAllPaged(Pageable pageable);

    Collection<NamesOnly> findByLastName(String lastName);
}