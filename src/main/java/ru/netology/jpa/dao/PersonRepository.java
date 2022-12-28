package ru.netology.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.jpa.domain.Person;
import ru.netology.jpa.domain.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByPersonId_AgeLessThanOrderByPersonId_Age(int age);

    Optional<Person> findByPersonId_NameAndPersonId_SurName(String name, String surName);
}
