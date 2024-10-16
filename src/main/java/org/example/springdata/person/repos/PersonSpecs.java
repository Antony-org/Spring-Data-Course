package org.example.springdata.person.repos;

import org.example.springdata.person.Person;

public class PersonSpecs {
    public static Specifications<Person> PersonsByAge(int age) {
        return (root, query, cb) -> cb.equal(root.get("age"), age);
    }
}
