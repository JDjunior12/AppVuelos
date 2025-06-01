package com.api.flights.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmptyListException extends RuntimeException{

    private String details;
    private String code;
    private String status;

}
