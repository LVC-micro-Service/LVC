package com.crudlvh.crudlvch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.entities.Endereco;
import com.crudlvh.crudlvch.repositories.EnderecoRepository;

@Service
public class EnderecoServico {

    @Autowired
    private EnderecoRepository repository;

    public Endereco inserir(Endereco endereco) {
        return repository.save(endereco);
    }
}
