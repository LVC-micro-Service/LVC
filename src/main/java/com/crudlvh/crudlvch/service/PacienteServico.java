package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.repositories.PacienteRepository;

@Service
public class PacienteServico {

    @Autowired
    private PacienteRepository repository;

    public Paciente inserir(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente salvarPaciente(CasoLVCDTO dto) {
        Paciente paciente = new Paciente(dto.getPaciente().getName(), dto.getPaciente().getHiv(),
            dto.getPaciente().getTelefone(), dto.getPaciente().getNomeMae(), dto.getPaciente().getPeso(),
            dto.getPaciente().getGestante(), dto.getPaciente().getNumCartaoSus(), dto.getPaciente().getEtniaEnum(),
            dto.getPaciente().getEscolaridade(), dto.getPaciente().getSexo());
    
        return inserir(paciente);
      }
      
    public Paciente findPacienteById(Long id) {
        return repository.getById(id);
    }
    
}
