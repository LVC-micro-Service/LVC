package com.crudlvh.crudlvch.controller;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
// import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.service.RegistroServico;

@RestController
@RequestMapping(value = "/registro")
public class RegistroCasoLVC {

  @Autowired
  private RegistroServico servico;

  @PostMapping("/inserir")
  public void salvarCasoLVC(@RequestBody CasoLVCDTO dto) {
  
    capturarCaso(dto);
  }

  public CasoLVC capturarCaso(CasoLVCDTO dto) {
    
    CasoLVC caso = new CasoLVC();

    servico.inserir(caso);

    // For each para salvar os sintomas
    // List<CasoSintoma> sintomas = dto.getSintomas().stream().collect(Collectors.toList());

    // sintomas.stream().forEach(e -> servico.inserirCasoSintoma(e));

    return caso;
  }

}
