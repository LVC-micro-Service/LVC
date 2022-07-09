package com.crudlvh.crudlvch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.TratamentoDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.Tratamento;
import com.crudlvh.crudlvch.service.CasoLVCServico;
import com.crudlvh.crudlvch.service.TratamentoServico;

@RestController
@RequestMapping(value = "/tratamento")
public class RegistroTratamentoInicialController {

    @Autowired
    private TratamentoServico service;

    @Autowired
    private CasoLVCServico casoService;

    @GetMapping(value = "/visualizar/{id}")
    public Tratamento findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(value = "/inserir/{id}")
    public Tratamento inserir(@PathVariable Long id, @RequestBody TratamentoDTO dto){
         CasoLVC caso = casoService.encontrarPorId(id);

         Tratamento t = new Tratamento(dto.getTratamento().getDataRegistro(), dto.getTratamento().getDroga(), dto.getTratamento().getDosagem(), caso);
         service.inserir(t);
         return t;
    }

}
