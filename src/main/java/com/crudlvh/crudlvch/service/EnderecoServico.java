package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.Endereco;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.repositories.EnderecoRepository;

@Service
public class EnderecoServico {

    @Autowired
    private EnderecoRepository repository;

    public Endereco inserir(Endereco endereco) {
        return repository.save(endereco);
    }

    public Endereco salvarEndereco(Paciente paciente, CasoLVCDTO dto) {
        Endereco endereco = new Endereco(paciente, dto.getPaciente().getEndereco().getCodigoIBGE(),
            dto.getPaciente().getEndereco().getUF(), dto.getPaciente().getEndereco().getMunicipio(),
            dto.getPaciente().getEndereco().getCep(), dto.getPaciente().getEndereco().getZona(),
            dto.getPaciente().getEndereco().getDistrito(), dto.getPaciente().getEndereco().getBairro(),
            dto.getPaciente().getEndereco().getLogradouro(), dto.getPaciente().getEndereco().getComplemento(),
            dto.getPaciente().getEndereco().getNumeroCasa());
    
        return inserir(endereco);
      }
}
