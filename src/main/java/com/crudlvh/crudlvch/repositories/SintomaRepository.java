package com.crudlvh.crudlvch.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudlvh.crudlvch.entities.Sintoma;

@Repository
public interface SintomaRepository extends JpaRepository<Sintoma, Long> {

    Sintoma getById(Long sintomaId);

    // @Query(value = "s.nome" +
    //         "  FROM sintoma s" +
    //         "  INNER JOIN municipio_caso e ON s.id = sintoma_id")
    // List<SintomasPorCasoDTO> sintomasPorCaso(Long id);
}