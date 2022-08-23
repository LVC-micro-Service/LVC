package com.crudlvh.crudlvch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.service.CasoLVCServicoCopy;
import com.fasterxml.jackson.core.JsonProcessingException;


@RestController
@RequestMapping(value = "/caso")
public class ListarCasosLVC {

    @Autowired
    private CasoLVCServicoCopy casoServicoCopy;


    @GetMapping(value = "/listar")
    public ResponseEntity<String> listarCasos() throws JsonProcessingException {
        List<String> casos;
        
        try {
            casos = casoServicoCopy.listarCasos();
            return new ResponseEntity<String>(casos.toString(), HttpStatus.OK);
        
        }catch(JsonProcessingException j){
            return new ResponseEntity<String>(j.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
