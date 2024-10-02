package com.satyabhushan.parkinglot.repositories;

import com.satyabhushan.parkinglot.models.Gate;
import com.satyabhushan.parkinglot.repositories.repositoryInterfaces.IGateRepository;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository implements IGateRepository {

    private Map<Long , Gate> gates = new TreeMap<>();

    public Optional<Gate> findGateById(Long gateId) {
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        return Optional.empty();
    }
}
