package com.api.flights.Repositories;

import com.api.flights.Models.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVuelosRepository extends JpaRepository<Vuelo,Long> {
}
