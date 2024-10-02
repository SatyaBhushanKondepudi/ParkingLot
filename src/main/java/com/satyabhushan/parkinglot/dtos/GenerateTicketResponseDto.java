package com.satyabhushan.parkinglot.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketResponseDto {
    private Long ticketId ;
    private String operatorName;
    private int parkingSpotNumber;
    private ResponseStatus responseStatus;
    private String message;
}
