package com.api.flights.Controller;

import com.api.flights.Dtos.ExceptionDto;
import com.api.flights.Exceptions.EmptyListException;
import com.api.flights.Exceptions.EmptyValueException;
import com.api.flights.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ExceptionDto> EmpityListEHandler(EmptyListException ex){
        ExceptionDto Error = ExceptionDto.builder().code(ex.getCode()).detail(ex.getDetails()).date(LocalDate.now()).status(ex.getStatus())
                .build();

        return new ResponseEntity<>(Error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> NotFoundEHandler(NotFoundException ex){
        ExceptionDto Error = ExceptionDto.builder().code(ex.getCode()).detail(ex.getDetails()).date(LocalDate.now()).status(ex.getStatus())
                .build();

        return new ResponseEntity<>(Error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyValueException.class)
    public ResponseEntity<ExceptionDto> EmptyValueEHandler(EmptyValueException ex){
        ExceptionDto Error = ExceptionDto.builder().code(ex.getCode()).detail(ex.getDetails()).date(LocalDate.now()).status(ex.getStatus())
                .build();

        return new ResponseEntity<>(Error, HttpStatus.BAD_REQUEST);
    }
}
