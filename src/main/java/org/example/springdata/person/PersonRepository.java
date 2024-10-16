package org.example.springdata.person;

import org.example.springdata.person.projection.NamesOnly;
import org.example.springdata.person.repos.CustomPersonRepo;
import org.example.springdata.person.repos.MyQueryRewriter;
import org.example.springdata.person.repos.PersonSpecs;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface PersonRepository extends JpaRepository<Person, Long>, CustomPersonRepo, JpaSpecificationExecutor<Person> {

    Stream<Person> streamAllPaged(Pageable pageable);


    Collection<NamesOnly> findByLastName(@Param("lastname") String lastName);

    @Query(value = "select p from #{#entityName} p where p.lastName = 'Stark'",
    queryRewriter = MyQueryRewriter.class)
    List<Person> findAll();

    @Procedure(name = "Person.getByFirstname")
    List<Person> getPersonByFirstname(@Param("first_name") String firstName);

    List<Person> getPersonByAge(int age);
}