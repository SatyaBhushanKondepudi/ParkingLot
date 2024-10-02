package com.satyabhushan.parkinglot.stratergies.spotAssignmentStratergy;

import com.satyabhushan.parkinglot.models.Enums.VehicleType;
import com.satyabhushan.parkinglot.models.Gate;
import com.satyabhushan.parkinglot.models.ParkingLot;
import com.satyabhushan.parkinglot.models.ParkingSpot;

import java.util.Optional;

public interface SpotAssignmentStratergy {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
