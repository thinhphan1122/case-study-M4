package com.winz_fast.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class SpecificationRequestDTO {
    private Long id;
    private String brand;
    private String carModel;
    private String engine;
    private String year;
    private String fuel;
    private String origin;
    private String gear;
    private Integer numberOfSeat;
    private Long productId;
}
