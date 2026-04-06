package com.app.quantitymeasurement.service;

import com.app.quantitymeasurement.dto.ConvertDTO;
import com.app.quantitymeasurement.dto.QuantityInputDTO;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;

import java.util.List;

public interface IQuantityMeasurementService {

    String compare(QuantityInputDTO input);

    double convertQuantity(ConvertDTO dto);

     double addQuantity(QuantityInputDTO input);

    List<QuantityMeasurementEntity> getHistory();
}