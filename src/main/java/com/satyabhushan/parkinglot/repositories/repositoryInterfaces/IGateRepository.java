package com.satyabhushan.parkinglot.repositories.repositoryInterfaces;

import com.satyabhushan.parkinglot.models.Gate;

import java.util.Optional;

public interface IGateRepository {
    Optional<Gate> findGateById(Long gateId);
}
