package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.ConvertDTO;
import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.exception.QuantityException;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
public String compare(QuantityInputDTO input) {

    double v1 = input.getThisQuantity().getValue();
    double v2 = input.getThatQuantity().getValue();

    boolean result = v1 == v2;

    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

    //  this quantity
    entity.setThisValue(v1);
    entity.setThisUnit(input.getThisQuantity().getUnit());
    entity.setThisMeasurementType(input.getThisQuantity().getMeasurementType());

    //  that quantity
    entity.setThatValue(v2);
    entity.setThatUnit(input.getThatQuantity().getUnit());
    entity.setThatMeasurementType(input.getThatQuantity().getMeasurementType());

    entity.setOperation("COMPARE");
    entity.setResultValue(result ? 1.0 : 0.0);

    repository.save(entity);

    return result ? "Equal" : "Not Equal";
}

    public double convert(double value, String fromUnit, String toUnit) {

        // FEET → INCH
        if (fromUnit.equals("FEET") && toUnit.equals("INCH")) {
            return value * 12;
        }

        // INCH → FEET
        if (fromUnit.equals("INCH") && toUnit.equals("FEET")) {
            return value / 12;
        }

        throw new QuantityException("Invalid Conversion");    }

    public double convertQuantity(ConvertDTO dto) {
        return convert(dto.getValue(), dto.getFromUnit(), dto.getToUnit());
    }

    public double add(double v1, double v2) {
        return v1 + v2;
    }

    public double addQuantity(QuantityInputDTO input) {

    double v1 = input.getThisQuantity().getValue();
    double v2 = input.getThatQuantity().getValue();

    double result = add(v1, v2);

    QuantityMeasurementEntity entity = new QuantityMeasurementEntity();

    //  this quantity
    entity.setThisValue(v1);
    entity.setThisUnit(input.getThisQuantity().getUnit());
    entity.setThisMeasurementType(input.getThisQuantity().getMeasurementType());

    //  that quantity
    entity.setThatValue(v2);
    entity.setThatUnit(input.getThatQuantity().getUnit());
    entity.setThatMeasurementType(input.getThatQuantity().getMeasurementType());

    entity.setOperation("ADD");
    entity.setResultValue(result);

    repository.save(entity);

    return result;
}

    public List<QuantityMeasurementEntity> getHistory() {
        return repository.findAll();
    }
}