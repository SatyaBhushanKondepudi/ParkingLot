package com.satyabhushan.parkinglot.repositories;

import com.satyabhushan.parkinglot.models.Gate;
import com.satyabhushan.parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    Map<Long ,ParkingLot> parkingLots = new TreeMap<>();
    public Optional<ParkingLot> getParkingLotOfGate(Gate gate) {
        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
}
