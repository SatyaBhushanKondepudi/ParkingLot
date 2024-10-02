package com.satyabhushan.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//@MappedSuperclass
@Getter
@Setter
public class BaseModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date createdAt;
    private Date updatedAt;
}
