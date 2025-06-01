package com.api.flights.Services;

import com.api.flights.Exceptions.EmptyListException;
import com.api.flights.Exceptions.EmptyValueException;
import com.api.flights.Exceptions.NotFoundException;
import com.api.flights.Models.Reserva;
import com.api.flights.Repositories.IReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private IReservaRepository iReservaRepository;

    public ResponseEntity<List<Reserva>> getAll(){
        List<Reserva> reservaList = this.iReservaRepository.findAll();
        if(reservaList.isEmpty()){
            throw new EmptyListException("No hay Reservas registradas","RFC-400","400");
        }

        return new ResponseEntity<>(reservaList, HttpStatus.OK);
    }

    public ResponseEntity<Optional<Reserva>> getById(Long id){
        Optional<Reserva> reservaOptional = this.iReservaRepository.findById(id);

        if(reservaOptional.isEmpty()){
            throw new NotFoundException("La reserva con el id:"+ id + ", no existe", "RFC-404", "404");
        }

        return new ResponseEntity<>(reservaOptional, HttpStatus.OK);
    }

    public ResponseEntity<Reserva> newReserva(Reserva reserva){
        if(reserva.getName().isEmpty()){
            throw new EmptyValueException("el valor: Name, esta vacio","RFC-404","404");
        }

        return new ResponseEntity<>(this.iReservaRepository.save(reserva),HttpStatus.CREATED);
    }

    public ResponseEntity<Reserva> updateReserva(Reserva reserva, Long id){

        Optional<Reserva> reservaOptional = this.iReservaRepository.findById(id);

        if(reservaOptional.isEmpty()){
            throw new NotFoundException("La reserva con el id:"+ id + ", no existe", "RFC-404", "404");
        }

        if(reserva.getName().isEmpty()){
            throw new EmptyValueException("el valor: Name, esta vacio","RFC-404","404");
        }

        reserva.setId(id);
        return new ResponseEntity<>(this.iReservaRepository.save(reserva), HttpStatus.OK);

    }

    public void deleteReserva(Long id){
        Optional<Reserva> reservaOptional = this.iReservaRepository.findById(id);

        if(reservaOptional.isEmpty()){
            throw new NotFoundException("La reserva con el id:"+ id + ", no existe", "RFC-404", "404");
        }
        this.iReservaRepository.deleteById(id);
    }
}
