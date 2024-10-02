package com.satyabhushan.parkinglot.models;

import com.satyabhushan.parkinglot.models.Enums.GateStatus;
import com.satyabhushan.parkinglot.models.Enums.GateType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel{
    private int gateNumber;
    private Operator currentOperator;
    private GateStatus gatestatus;
    private GateType gateType;
}
