package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service){
        this.service = service;
    }

    public void performConversion(QuantityDTO dto, String target){
        QuantityDTO result = service.convert(dto, target);
        System.out.println("Converted Value: " + result.getValue());
    }

    public void performAddition(QuantityDTO q1, QuantityDTO q2){
        QuantityDTO result = service.add(q1, q2);
        System.out.println("Addition Result: " + result.getValue());
    }
}