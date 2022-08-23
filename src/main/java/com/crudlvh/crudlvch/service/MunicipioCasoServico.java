package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.repositories.MunicipioCasoRepository;

@Service
public class MunicipioCasoServico {

    @Autowired
    private MunicipioCasoRepository repository;
    
    public MunicipioCaso inserir(MunicipioCaso municipioCaso){
        return repository.save(municipioCaso);
    }

    public MunicipioCaso findMunicipioByCasoId(Long id){
        return repository.findByCasoId(id);
    }

    public MunicipioCaso salvarMunicipioCaso(CasoLVC caso, Paciente paciente, CasoLVCDTO dto) {
        MunicipioCaso municipioCaso = new MunicipioCaso(caso, paciente, dto.retornarCodigoIbge());
    
        return inserir(municipioCaso);
      }

}
