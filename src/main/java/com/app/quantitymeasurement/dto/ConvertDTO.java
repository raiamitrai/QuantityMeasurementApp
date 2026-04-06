package com.app.quantitymeasurement.dto;

import lombok.Data;

@Data
public class ConvertDTO {

    private double value;
    private String fromUnit;
    private String toUnit;
}