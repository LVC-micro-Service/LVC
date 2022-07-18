package com.crudlvh.crudlvch.controller;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.service.CasoLVCServico;

@RestController
@RequestMapping(value = "/caso")
public class RegistroCasoLVC {

  @Autowired
  private CasoLVCServico servico;


  @PostMapping("/inserir")
  public ResponseEntity<String> salvarCasoLVC(@RequestBody CasoLVCDTO dto) {

    return capturarCaso(dto);
  }


  @Transactional(rollbackOn = {Exception.class, NullPointerException.class})
  public ResponseEntity<String> capturarCaso(CasoLVCDTO dto) {
    try {
        servico.inserir(dto);
        return new ResponseEntity<>("Caso registrado com sucesso", HttpStatus.OK);
    } catch (NullPointerException e) {
      return new ResponseEntity<String>("" + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  

}