package com.ept.eptmanagement.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Data
@Entity
@SuperBuilder
public class Admin extends User {
}

