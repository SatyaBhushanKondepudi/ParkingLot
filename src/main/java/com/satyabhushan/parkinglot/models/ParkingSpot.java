package com.satyabhushan.parkinglot.models;

import com.satyabhushan.parkinglot.models.Enums.ParkingSpotStatus;
import com.satyabhushan.parkinglot.models.Enums.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ParkingSpot extends BaseModel{
    private int spotNumber;

    private List<VehicleType> supportedVehicleTypes;

    private ParkingSpotStatus parkingSpotStatus;

    private Vehicle vehicle ;

}
