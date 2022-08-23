package com.crudlvh.crudlvch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.repositories.CasoSintomaRepository;
import com.crudlvh.crudlvch.repositories.SintomaRepository;

@Service
public class CasoSintomaServico {
    
    @Autowired
    private CasoSintomaRepository repository;

    @Autowired
    private SintomaRepository sintomaRepository;
    
    public CasoSintoma inserir(CasoSintoma casoSintoma){
       return repository.save(casoSintoma);
    }
    
    public List<CasoSintoma> findSintomas(Long id){
        return repository.findByCasoId(id);
    }

    public List<CasoSintoma> salvarSintomas(List<Sintoma> sintomas, CasoLVC caso) {
        List<CasoSintoma> casosSintomas = new ArrayList<>();
        for (Sintoma item : sintomas) {
          Sintoma sintoma = sintomaRepository.getById(item.retornarId());
          CasoSintoma casoSintoma = new CasoSintoma(caso, sintoma);
    
          casosSintomas.add(inserir(casoSintoma));
        }
        return casosSintomas;
      }

}
