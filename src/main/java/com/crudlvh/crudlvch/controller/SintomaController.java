package com.crudlvh.crudlvch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.service.SintomaServico;

@RestController
@RequestMapping(value = "/sintoma")
public class SintomaController {

@Autowired
private SintomaServico service;

    public Optional<Sintoma> findSintomaById(Long sintomaId) {
        return service.findSintomaById(sintomaId);
    }

}
