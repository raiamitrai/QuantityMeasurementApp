package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.dto.ConvertDTO;
import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public String compare(@RequestBody QuantityInputDTO input) {
        System.out.println("🔥 API HIT 🔥");
        return service.compare(input);
    }

    @PostMapping("/convert")
    public double convert(@RequestBody ConvertDTO dto) {
        return service.convertQuantity(dto);
    }
    @PostMapping("/add")
    public double add(@RequestBody QuantityInputDTO input) {
        return service.addQuantity(input);
    }

    @GetMapping("/history")
    public List<QuantityMeasurementEntity> getHistory() {
        return service.getHistory();
    }
}