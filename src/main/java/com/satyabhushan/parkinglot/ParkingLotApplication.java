package com.satyabhushan.parkinglot;

import com.satyabhushan.parkinglot.controller.TicketController;
import com.satyabhushan.parkinglot.repositories.GateRepository;
import com.satyabhushan.parkinglot.repositories.ParkingLotRepository;
import com.satyabhushan.parkinglot.repositories.TicketRepository;
import com.satyabhushan.parkinglot.repositories.VehicleRepository;
import com.satyabhushan.parkinglot.services.TicketService;
import com.satyabhushan.parkinglot.stratergies.spotAssignmentStratergy.RandomSpotAssignmentStratergy;
import com.satyabhushan.parkinglot.stratergies.spotAssignmentStratergy.SpotAssignmentStratergy;

public class ParkingLotApplication {

    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStratergy spotAssignmentStratergy = new RandomSpotAssignmentStratergy();

        TicketService ticketService = new TicketService(
                gateRepository , vehicleRepository , spotAssignmentStratergy , ticketRepository , parkingLotRepository
        );
        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started on port : 8080");

    }

}
