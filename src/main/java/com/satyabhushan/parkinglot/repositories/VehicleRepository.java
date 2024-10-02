package com.satyabhushan.parkinglot.repositories;

import com.satyabhushan.parkinglot.models.Vehicle;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber){
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        return null;
    }
}
