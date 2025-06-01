package com.api.flights.Controller;


import com.api.flights.Models.Vuelo;
import com.api.flights.Services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/vuelo")
public class VueloController {

    @Autowired
    VueloService vueloService;

    @GetMapping
    public ResponseEntity<List<Vuelo>> getAll(){
        return this.vueloService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vuelo>> getById(@PathVariable Long id){
        return this.vueloService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Vuelo> newVuelo(@RequestBody Vuelo vuelo){
        return this.vueloService.newVuelo(vuelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> updateVuelo(@PathVariable Long id, @RequestBody Vuelo vuelo){
        return this.vueloService.updateVuelo(vuelo,id);
    }

    @DeleteMapping("/{id}")
    public void deleteVuelo(@PathVariable Long id){
        this.vueloService.deletevuelo(id);
    }
}
