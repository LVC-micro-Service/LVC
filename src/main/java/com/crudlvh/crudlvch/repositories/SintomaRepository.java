package com.crudlvh.crudlvch.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.Sintoma;

@Repository
public interface SintomaRepository extends JpaRepository<Sintoma, Long> {

    Optional<Sintoma> findById(Long sintomaId);
}