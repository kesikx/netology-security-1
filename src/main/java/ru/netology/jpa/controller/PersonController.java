package ru.netology.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jpa.dto.PersonResponse;
import ru.netology.jpa.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("by-city")
    public ResponseEntity<List<PersonResponse>> getPersonByCity(@RequestParam String city) {
        var personList = personService.findByCity(city);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("by-max-age")
    public ResponseEntity<List<PersonResponse>> getPersonByCity(@RequestParam int age) {
        var personList = personService.findByMaxAge(age);
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    @GetMapping("by-name")
    public ResponseEntity<PersonResponse> getPersonByCity(@RequestParam String name, @RequestParam String surname) {
        var person = personService.findByNameAndSurName(name, surname);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
