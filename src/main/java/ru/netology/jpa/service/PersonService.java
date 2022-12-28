package ru.netology.jpa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.jpa.dao.PersonRepository;
import ru.netology.jpa.dto.PersonResponse;
import ru.netology.jpa.exception.NotFoundException;
import ru.netology.jpa.mapper.PersonResponseMapper;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public List<PersonResponse> findByCity(String city) {
        var personList = personRepository.findByCityOfLiving(city);
        return personList.stream().map(PersonResponseMapper::transform).toList();
    }

    @Transactional
    public List<PersonResponse> findByMaxAge(int age) {
        var personList = personRepository.findByPersonId_AgeLessThanOrderByPersonId_Age(age);
        return personList.stream().map(PersonResponseMapper::transform).toList();
    }

    @Transactional
    public PersonResponse findByNameAndSurName(String name, String surName) {
        var person = personRepository.findByPersonId_NameAndPersonId_SurName(name, surName)
                .orElseThrow(() -> new NotFoundException(
                        "Person with name " + name + " and surname " + surName + " not found")
                );
        return PersonResponseMapper.transform(person);
    }
}
