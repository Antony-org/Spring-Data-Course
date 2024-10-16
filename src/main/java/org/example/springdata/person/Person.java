package org.example.springdata.person;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Person.findByLastName", query = "select p from Person p where p.lastName = 'Stark'")
@NamedStoredProcedureQuery(
        name = "Person.getByFirstname",
        procedureName = "get_person_by_firstname",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "first_name", type = String.class)
        },
        resultClasses = Person.class
)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;

    // Constructors
    public Person() {}

    public Person(String firstName, String lastName, int age, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}