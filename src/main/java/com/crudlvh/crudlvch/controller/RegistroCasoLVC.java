package com.crudlvh.crudlvch.controller;



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


  // Recebe a DTO para inserir um caso e a lógica das regras de negócio são tratadas na classe de serviço
  @PostMapping("/inserir")
  public ResponseEntity<String> inserir(@RequestBody CasoLVCDTO dto) {
    try {
        servico.registrarCaso(dto);
        return new ResponseEntity<>("Caso registrado com sucesso", HttpStatus.OK);
    } catch (NullPointerException e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

  }



  

}