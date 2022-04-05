package com.ept.eptmanagement.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Student extends User {
    private String option; //education
}
