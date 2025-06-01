package com.api.flights.Services;

import com.api.flights.Exceptions.EmptyListException;
import com.api.flights.Exceptions.EmptyValueException;
import com.api.flights.Exceptions.NotFoundException;
import com.api.flights.Models.User;
import com.api.flights.Models.Vuelo;
import com.api.flights.Repositories.IUserRepository;
import com.api.flights.Repositories.IVuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {

    @Autowired
    private IVuelosRepository iVuelosRepository;

    public ResponseEntity<List<Vuelo>> getAll(){
        List<Vuelo> vueloList = this.iVuelosRepository.findAll();
        if(vueloList.isEmpty()){
            throw new EmptyListException("No hay vuelos registrados","RFC-400","400");
        }

        return new ResponseEntity<>(vueloList, HttpStatus.OK);
    }

    public ResponseEntity<Optional<Vuelo>> getById(Long id){
        Optional<Vuelo> vueloOptional = this.iVuelosRepository.findById(id);

        if(vueloOptional.isEmpty()){
            throw new NotFoundException("El Vuelo con el id:"+ id + ", no existe", "RFC-404", "404");
        }

        return new ResponseEntity<>(vueloOptional, HttpStatus.OK);
    }

    public ResponseEntity<Vuelo> newVuelo(Vuelo vuelo){
        if(vuelo.getOrigen().isEmpty() || vuelo.getDestino().isEmpty()){
            throw new EmptyValueException("el valor: origen o el valor: destino, esta vacio","RFC-404","404");
        }

        return new ResponseEntity<>(this.iVuelosRepository.save(vuelo),HttpStatus.CREATED);
    }

    public ResponseEntity<Vuelo> updateVuelo(Vuelo vuelo, Long id){

        Optional<Vuelo> vueloOptional = this.iVuelosRepository.findById(id);

        if(vueloOptional.isEmpty()){
            throw new NotFoundException("El vuelo con el id:"+ id + ", no existe", "RFC-404", "404");
        }

        if(vuelo.getOrigen().isEmpty() || vuelo.getDestino().isEmpty()){
            throw new EmptyValueException("el valor: origen o el valor: destino, esta vacio","RFC-404","404");
        }

        vuelo.setId(id);
        return new ResponseEntity<>(this.iVuelosRepository.save(vuelo), HttpStatus.OK);

    }

    public void deletevuelo(Long id){
        Optional<Vuelo> userOptional = this.iVuelosRepository.findById(id);

        if(userOptional.isEmpty()){
            throw new NotFoundException("El vuelo con el id:"+ id + ", no existe", "RFC-404", "404");
        }
        this.iVuelosRepository.deleteById(id);
    }
}
