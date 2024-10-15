package org.example.springdata.person.repos;

import org.example.springdata.person.Person;
import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

class CustomPersonRepoImpl implements CustomPersonRepo {

    @Override
    public void whatever(Person person) {
        
    }

    @Override
    public Stream<Person> streamAllPaged(Pageable pageable) {
        return Stream.empty();
    }
}