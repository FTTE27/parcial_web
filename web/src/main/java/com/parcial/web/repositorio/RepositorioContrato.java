package com.parcial.web.repositorio;

import org.springframework.stereotype.Repository;

import com.parcial.web.modelo.Contrato;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RepositorioContrato extends CrudRepository<Contrato, Integer>{

    @Query("SELECT c FROM Contratos c WHERE c.id = :id")
    Optional<Contrato> findById(@Param("id") int id);
}
