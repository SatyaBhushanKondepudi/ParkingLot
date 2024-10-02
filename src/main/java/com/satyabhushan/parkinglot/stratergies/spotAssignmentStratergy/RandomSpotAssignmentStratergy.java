package com.satyabhushan.parkinglot.stratergies.spotAssignmentStratergy;

import com.satyabhushan.parkinglot.models.Enums.ParkingSpotStatus;
import com.satyabhushan.parkinglot.models.Enums.VehicleType;
import com.satyabhushan.parkinglot.models.Gate;
import com.satyabhushan.parkinglot.models.ParkingFloor;
import com.satyabhushan.parkinglot.models.ParkingLot;
import com.satyabhushan.parkinglot.models.ParkingSpot;

import java.util.Optional;

public class RandomSpotAssignmentStratergy implements SpotAssignmentStratergy{
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType,ParkingLot parkingLot, Gate gate) {
            for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
                for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                    if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)
                            && parkingSpot.getSupportedVehicleTypes().contains(vehicleType)) {
                        return Optional.of(parkingSpot);
                    }
                }
            }
        return Optional.empty();
    }
}
