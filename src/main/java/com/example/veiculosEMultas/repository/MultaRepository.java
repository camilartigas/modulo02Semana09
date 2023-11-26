package com.example.veiculosEMultas.repository;


import com.example.veiculosEMultas.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {
}