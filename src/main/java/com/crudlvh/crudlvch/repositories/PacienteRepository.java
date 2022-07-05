package com.crudlvh.crudlvch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudlvh.crudlvch.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
}
