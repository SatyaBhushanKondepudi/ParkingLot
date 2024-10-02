package com.satyabhushan.parkinglot.exceptions;

public class NoAvailableSpotException extends Exception{
    public NoAvailableSpotException(String message){
        super(message);
    }
}
