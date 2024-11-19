package com.parcial.web.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial.web.dto.ContratoDTO;
import com.parcial.web.modelo.Contrato;
import com.parcial.web.repositorio.*;


import java.time.Duration;
import java.util.Optional;

public class ServicioContrato {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RepositorioContrato repositorioContratos;

    public boolean checkCamposContrato(ContratoDTO contrato) 
    {
        if (contrato == null) {
            return false; 
        }

        if (contrato.getIdentificador() == null || contrato.getNombre_contratante() == null || 
            contrato.getDocumento_contratante() == null || contrato.getNombre_contratista() == null ||
            contrato.getDocumento_contratista() == null || contrato.getValor() == 0 || 
            contrato.getFecha_inicial() == null || contrato.getFecha_final() == null)
            return false;
        
        return true;
    }

    public Contrato saveContrato(ContratoDTO contratoDTO){
        if (checkCamposContrato(contratoDTO)){
            Contrato nuevoCont = modelMapper.map(contratoDTO, Contrato.class);
            return repositorioContratos.save(nuevoCont);
        }
                return null;
    }

    public Iterable<Contrato> getContratos(){
        return repositorioContratos.findAll();
    }

    public Optional<Contrato> findbyID(Integer contratoID){
        return repositorioContratos.findById(contratoID);
    }

    public void deletebyID(Integer contratoID){
        repositorioContratos.deleteById(contratoID);
        return;
    }

    public Contrato actualizaContrato(ContratoDTO contratoDTO){
        if (checkCamposContrato(contratoDTO)){
            Contrato nuevoCont = modelMapper.map(contratoDTO, Contrato.class);
            return repositorioContratos.save(nuevoCont);
        }
                return null;
    }

}

