package com.apps.quantitymeasurement.service;

import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurement.exception.QuantityMeasurementException;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository){
        this.repository = repository;
    }

    @Override
    public QuantityDTO convert(QuantityDTO input, String targetUnit) {

        try{
            // TODO logic later
            QuantityMeasurementEntity entity =
                    new QuantityMeasurementEntity("CONVERT","SUCCESS");
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