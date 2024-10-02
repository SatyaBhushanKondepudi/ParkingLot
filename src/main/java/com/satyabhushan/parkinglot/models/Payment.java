package com.satyabhushan.parkinglot.models;

import com.satyabhushan.parkinglot.models.Enums.PaymentMode;
import com.satyabhushan.parkinglot.models.Enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private  String referenceId;
    private Bill bill ;
    private Date time;

}
