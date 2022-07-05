package com.crudlvh.crudlvch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.service.RegistroServico;

@RestController
@RequestMapping(value = "/registro")
public class RegistroCasoLVC {

    @Autowired
    private RegistroServico servico;

    @PostMapping("/new")
    public void salvarCasoLVC(CasoLVCDTO dto) {
      CasoLVC caso = capturarCaso(dto);

      servico.inserir(caso);
    }

    public CasoLVC capturarCaso(CasoLVCDTO dto) {
        CasoLVC caso = new CasoLVC();
    
        return caso;
    }

}
