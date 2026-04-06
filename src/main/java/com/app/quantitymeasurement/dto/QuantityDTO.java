package com.app.quantitymeasurement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class QuantityDTO {

    @NotNull
    private Double value;

    @NotBlank
    private String unit;

    @NotBlank
    private String measurementType;
}