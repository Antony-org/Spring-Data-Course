package org.example.springdata.person.repos;

import org.example.springdata.person.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface CustomPersonRepo {
    void whatever(Person person);

    @Query("select p from Person p")
    Stream<Person> streamAllPaged(Pageable pageable);

}
