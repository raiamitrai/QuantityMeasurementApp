package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    public QuantityMeasurementEntity save(QuantityMeasurementEntity entity){
        return repository.save(entity);
    }

    public List<QuantityMeasurementEntity> getAll(){
        return repository.findAll();
    }

    public long count(){
        return repository.count();
    }
}