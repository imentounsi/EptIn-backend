package com.ept.eptmanagement.dto;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class OffreDto {
    private Long id;
    private Long exstudentId;
    private String name;
    private String authority ;
    private String field ;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private String type;
    private String comment;
    private Date startDate;
    private Date endDate;
}
