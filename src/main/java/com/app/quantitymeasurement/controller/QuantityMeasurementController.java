package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.service.QuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quantity")
public class QuantityMeasurementController {

    @Autowired
    private QuantityMeasurementService service;

    @PostMapping("/save")
    public QuantityMeasurementEntity save(@RequestBody QuantityMeasurementEntity entity){
        return service.save(entity);
    }

    @GetMapping("/all")
    public List<QuantityMeasurementEntity> getAll(){
        return service.getAll();
    }

    @GetMapping("/count")
    public long count(){
        return service.count();
    }
}