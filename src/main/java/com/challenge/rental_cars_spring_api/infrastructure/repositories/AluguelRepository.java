package com.challenge.rental_cars_spring_api.infrastructure.repositories;

import com.challenge.rental_cars_spring_api.core.domain.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}