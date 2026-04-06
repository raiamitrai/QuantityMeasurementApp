package com.app.quantitymeasurement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double thisValue;
    private String thisUnit;
    private String thisMeasurementType;

    private double thatValue;
    private String thatUnit;
    private String thatMeasurementType;

    private String operation;

    private Double resultValue;
    private String resultUnit;

    private String errorMessage;
    private boolean isError;
}