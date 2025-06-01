package com.api.flights.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends RuntimeException{

    private String details;
    private String code;
    private String status;

}
