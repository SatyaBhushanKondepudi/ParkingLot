package com.satyabhushan.parkinglot.controller;

import com.satyabhushan.parkinglot.dtos.GenerateTicketRequestDto;
import com.satyabhushan.parkinglot.dtos.GenerateTicketResponseDto;
import com.satyabhushan.parkinglot.dtos.ResponseStatus;
import com.satyabhushan.parkinglot.exceptions.InvalidGateException;
import com.satyabhushan.parkinglot.exceptions.NoAvailableSpotException;
import com.satyabhushan.parkinglot.exceptions.NoGateException;
import com.satyabhushan.parkinglot.models.Enums.VehicleType;
import com.satyabhushan.parkinglot.models.Gate;
import com.satyabhushan.parkinglot.models.Ticket;
import com.satyabhushan.parkinglot.models.Vehicle;
import com.satyabhushan.parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto) {
        String vehicleNumber = requestDto.getVehicleNumber();
        VehicleType vehicleType = requestDto.getVehicleType();
        Long gateId = requestDto.getGateId();

        Ticket ticket = new Ticket();
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();

        try{
            ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);
        }
        catch (InvalidGateException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage("Gate ID is invalid");
            return responseDto;
        }
        catch (NoAvailableSpotException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage("No Parking Spot Available");
            return responseDto;
        }


        responseDto.setTicketId(ticket.getId());
        responseDto.setOperatorName(ticket.getOperator().getOperatorName());
        responseDto.setParkingSpotNumber(ticket.getParkingSpot().getSpotNumber());
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        responseDto.setMessage("Ticket generated successfully");
        return responseDto;
    }
}
