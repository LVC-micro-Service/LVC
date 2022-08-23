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
        Paciente paciente = new Paciente(dto.retornarPaciente().retornarNome(), dto.retornarPaciente().retornarHiv(),
            dto.retornarPaciente().retornarTelefone(), dto.retornarPaciente().retornarNomeMae(), dto.retornarPaciente().retornarPeso(),
            dto.retornarPaciente().retornarGestante(), dto.retornarPaciente().retornarNumCartaoSus(), dto.retornarPaciente().retornarEtniaEnum(),
            dto.retornarPaciente().retornarEscolaridade(), dto.retornarPaciente().retornarSexo());
    
        return inserir(paciente);
      }
      
    public Paciente findPacienteById(Long id) {
        return repository.getById(id);
    }
    
}
