package com.app.quantitymeasurement.dto;

import lombok.Data;

@Data
public class QuantityInputDTO {

    private QuantityDTO thisQuantity;
    private QuantityDTO thatQuantity;
}