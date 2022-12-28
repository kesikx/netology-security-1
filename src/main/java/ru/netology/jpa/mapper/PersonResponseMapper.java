package ru.netology.jpa.mapper;

import ru.netology.jpa.dto.PersonResponse;
import ru.netology.jpa.domain.Person;

public class PersonResponseMapper {
    public static PersonResponse transform(Person person) {
        var personId = person.getPersonId();
        return PersonResponse.builder()
                .name(personId.getName())
                .surName(personId.getSurName())
                .age(personId.getAge())
                .phoneNumber(person.getPhoneNumber())
                .cityOfLiving(person.getCityOfLiving())
                .build();
    }
}
