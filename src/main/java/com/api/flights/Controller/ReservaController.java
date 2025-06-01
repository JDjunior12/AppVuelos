package com.api.flights.Controller;

import com.api.flights.Models.Reserva;
import com.api.flights.Models.User;
import com.api.flights.Services.ReservaService;
import com.api.flights.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/res")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> getAll(){
        return this.reservaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reserva>> getById(@PathVariable Long id){
        return this.reservaService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Reserva> newReserva(@RequestBody Reserva res){
        return this.reservaService.newReserva(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody Reserva res){
        return this.reservaService.updateReserva(res,id);
    }

    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id){
        this.reservaService.deleteReserva(id);
    }
}
