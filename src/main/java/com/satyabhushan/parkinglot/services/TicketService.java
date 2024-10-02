package com.satyabhushan.parkinglot.services;

import com.satyabhushan.parkinglot.exceptions.InvalidGateException;
import com.satyabhushan.parkinglot.exceptions.NoAvailableSpotException;
import com.satyabhushan.parkinglot.exceptions.NoGateException;
import com.satyabhushan.parkinglot.models.*;
import com.satyabhushan.parkinglot.models.Enums.VehicleType;
import com.satyabhushan.parkinglot.repositories.GateRepository;
import com.satyabhushan.parkinglot.repositories.ParkingLotRepository;
import com.satyabhushan.parkinglot.repositories.TicketRepository;
import com.satyabhushan.parkinglot.repositories.VehicleRepository;
import com.satyabhushan.parkinglot.stratergies.spotAssignmentStratergy.SpotAssignmentStratergy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStratergy spotAssignmentStratergy;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         SpotAssignmentStratergy spotAssignmentStratergy,
                         TicketRepository ticketRepository,
                         ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStratergy = spotAssignmentStratergy;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long gateId , VehicleType vehicleType , String vehicleNumber) throws InvalidGateException, NoAvailableSpotException {
         /*
        Gate = get gate for that id from db. Else throw an exception
        Operator = from gate
        Vehicle = check if already in DB. If yes, get that. Else, create
        ParkingSpot = strategy
        Ticket ticket =
         */

        //1.Gate = get gate for that id from db. Else throw an exception
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new InvalidGateException("Invalid GateID provided");
        }
        Gate gate = gateOptional.get();

        //2.Operator = from gate
        Operator operator = gate.getCurrentOperator();

        //3. Vehicle = check if already in DB. If yes, get that. Else, create
        Vehicle vehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if(!vehicleOptional.isEmpty()){
            vehicle = vehicleOptional.get();
        }
        else{
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        }

        //4. ParkingSpot = strategy
        Optional<ParkingLot> parkingLot = parkingLotRepository.getParkingLotOfGate(gate);
        if(parkingLot.isEmpty()){
            throw new InvalidGateException("Parking lot with " + gateId + "doesn't exist");
        }
        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStratergy.findSpot(
                vehicleType, parkingLot.get(),gate);

        if(parkingSpotOptional.isEmpty()){
            throw new NoAvailableSpotException("No Available Spotin the Parking Lot");
        }

        ParkingSpot parkingSpot = parkingSpotOptional.get();


        //5. Create the ticket & save it to ticketRepository
        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setEntryGate(gate);
        ticket.setOperator(operator);

        return ticketRepository.save(ticket);
    }
}
