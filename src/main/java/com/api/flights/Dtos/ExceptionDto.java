package com.api.flights.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ExceptionDto {

    private String detail;
    private String status;
    private String code;
    private LocalDate date;
}
