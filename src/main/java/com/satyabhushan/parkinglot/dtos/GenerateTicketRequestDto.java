package com.satyabhushan.parkinglot.dtos;

import com.satyabhushan.parkinglot.models.Enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long gateId;
}
