package com.parcial.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ContratoDTO {

    private String Identificador;
    private double Valor;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratista;
    private String documento_contratista;
    private Date Fecha_inicial;
    private Date Fecha_final;
}


