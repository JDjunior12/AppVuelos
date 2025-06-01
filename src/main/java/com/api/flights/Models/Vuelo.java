package com.api.flights.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "value")
    private int value;

    @Column(name = "num_pasajeros")
    private int num_pasajeros;

    @Column(name = "compañia")
    private String compañia;

    @Column(name = "name")
    private String name;

}
