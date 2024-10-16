package org.example.springdata.person.repos;

import org.example.springdata.person.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecs {
    public static Specification<Person> PersonsByAge(int age) {
        return (root, query, cb) -> cb.equal(root.get("age"), age);
    }
}
