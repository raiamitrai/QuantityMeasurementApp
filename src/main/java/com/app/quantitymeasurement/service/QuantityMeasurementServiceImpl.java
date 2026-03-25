package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.QuantityDTO;
import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.app.quantitymeasurement.exception.QuantityMeasurementException;
import com.app.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository){
        this.repository = repository;
    }

    @Override
    public QuantityDTO convert(QuantityDTO input, String targetUnit) {

        try{

            String operand1 =
                    input.getValue() + " " + input.getUnit();

            String operand2 =
                    targetUnit;

            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity(
                            operand1,
                            operand2,
                            input.getMeasurementType(),
                            "CONVERT",
                            "DUMMY_RESULT",
                            false,
                            "SUCCESS"
                    );

            repository.save(entity);

            return input;
    }
    catch (Exception e){
        throw new QuantityMeasurementException(e.getMessage());
    }
}

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return false;
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        return q1;
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        return q1;
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {
        return 0;
    }
}