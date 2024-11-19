package com.parcial.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parcial.web.dto.ContratoDTO;
import com.parcial.web.modelo.Contrato;
import com.parcial.web.servicio.ServicioContrato;

import java.util.Optional;

@RestController
@RequestMapping("/api/contratos")
public class ControladorContrato {
    @Autowired
    private ServicioContrato servicioContrato;

    // Crear un nuevo contrato
    @PostMapping
    public ResponseEntity<Contrato> crearContrato(@RequestBody ContratoDTO contratoDTO) {
        Contrato contratoGuardado = servicioContrato.saveContrato(contratoDTO);
        
        if (contratoGuardado != null) {
            return new ResponseEntity<>(contratoGuardado, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Obtener todos los contratos
    @GetMapping
    public ResponseEntity<Iterable<Contrato>> obtenerContratos() {
        Iterable<Contrato> contratos = servicioContrato.getContratos();
        return new ResponseEntity<>(contratos, HttpStatus.OK);
    }

    // Obtener contrato por ID
    @GetMapping("/{id}")
    public ResponseEntity<Contrato> obtenerContratoPorId(@PathVariable("id") Integer contratoID) {
        Optional<Contrato> contrato = servicioContrato.findbyID(contratoID);
        
        if (contrato.isPresent()) {
            return new ResponseEntity<>(contrato.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar contrato por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContrato(@PathVariable("id") Integer contratoID) {
        Optional<Contrato> contrato = servicioContrato.findbyID(contratoID);
        
        if (contrato.isPresent()) {
            servicioContrato.deletebyID(contratoID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar contrato
    @PutMapping("/{id}")
    public ResponseEntity<Contrato> actualizarContrato(@PathVariable("id") Integer contratoID, 
                                                      @RequestBody ContratoDTO contratoDTO) {
        Optional<Contrato> contratoExistente = servicioContrato.findbyID(contratoID);
        
        if (contratoExistente.isPresent()) {
            contratoDTO.setIdentificador(contratoExistente.get().getIdentificador());  // Mantener el mismo identificador
            Contrato contratoActualizado = servicioContrato.actualizaContrato(contratoDTO);
            return new ResponseEntity<>(contratoActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
