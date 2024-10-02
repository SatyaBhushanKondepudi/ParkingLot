package com.satyabhushan.parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel{

    private ParkingSpot parkingSpot;


    private Date entryTime;

    private Vehicle vehicle;

    private Gate entryGate ;

    private Operator operator;

}
