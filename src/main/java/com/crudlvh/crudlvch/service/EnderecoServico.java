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
        Endereco endereco = new Endereco(paciente, dto.retornarPaciente().retornarEndereco().retornarCodigoIBGE(),
            dto.retornarPaciente().retornarEndereco().retornarUF(), dto.retornarPaciente().retornarEndereco().retornarMunicipio(),
            dto.retornarPaciente().retornarEndereco().retornarCep(), dto.retornarPaciente().retornarEndereco().retornarZona(),
            dto.retornarPaciente().retornarEndereco().retornarDistrito(), dto.retornarPaciente().retornarEndereco().retornarBairro(),
            dto.retornarPaciente().retornarEndereco().retornarLogradouro(), dto.retornarPaciente().retornarEndereco().retornarComplemento(),
            dto.retornarPaciente().retornarEndereco().retornarNumeroCasa());
    
        return inserir(endereco);
      }
}
