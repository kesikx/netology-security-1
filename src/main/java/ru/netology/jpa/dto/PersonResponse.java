package ru.netology.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {
    private String name;

    private String surName;

    private int age;

    private String phoneNumber;

    private String cityOfLiving;
}
