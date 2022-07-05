package com.crudlvh.crudlvch.controller;

import java.util.List;
import java.util.stream.Collectors;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.service.CasoSintomaServico;
import com.crudlvh.crudlvch.service.RegistroServico;
import com.crudlvh.crudlvch.service.SintomaServico;

@RestController
@RequestMapping(value = "/registro")
public class RegistroCasoLVC {

  @Autowired
  private RegistroServico servico;

  @Autowired
  private SintomaServico sintomaServico;

  @Autowired
  private CasoSintomaServico casoSintomaServico;


  @PostMapping("/inserir")
  public void salvarCasoLVC(@RequestBody CasoLVCDTO dto) {

    capturarCaso(dto);
  }

  public CasoLVC capturarCaso(CasoLVCDTO dto) {
    CasoLVC caso = new CasoLVC(dto.getDataRegistro());
    servico.inserir(caso);
    
    List<Sintoma> sintomas = dto.getSintomas().stream().collect(Collectors.toList());

    for (Sintoma item : sintomas) {
      Sintoma sintoma = sintomaServico.findSintomaById(item.getId());
      CasoSintoma casoSintoma = new CasoSintoma(caso, sintoma);
      casoSintomaServico.inserir(casoSintoma);
    }
    
    return caso;
  }

}
