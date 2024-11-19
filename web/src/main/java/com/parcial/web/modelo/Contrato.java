package com.parcial.web.modelo;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Contrato implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;
    protected String Identificador;
    protected double Valor;
    protected String nombre_contratante;
    protected String documento_contratante;
    protected String nombre_contratista;
    protected String documento_contratista;
    protected Date Fecha_inicial;
    protected Date Fecha_final;

}


