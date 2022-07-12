package com.crudlvh.crudlvch.controller;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crudlvh.crudlvch.dto.ConclusaoDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.Conclusao;
import com.crudlvh.crudlvch.entities.EvolucaoEnum;
import com.crudlvh.crudlvch.service.CasoLVCServico;
import com.crudlvh.crudlvch.service.ConclusaoServico;

@RestController
@RequestMapping(value = "/caso")
public class RegistroConclusaoController {

    @Autowired
    private ConclusaoServico service;

    @Autowired
    private CasoLVCServico casoServico;

    @Transactional(rollbackOn= {Exception.class, NullPointerException.class})
    @PostMapping(value = "/conclusao/{id}")
    public ResponseEntity<String> salvarConclusao(@PathVariable Long id, @RequestBody ConclusaoDTO dto) {

        try {
            CasoLVC caso = casoServico.encontrarPorId(id);
            if (!caso.equals(null)) {

                Conclusao conclusao = service.findByCasoLVCId(id);



                if (conclusao != null) {
                    throw new Exception("Conclusão já cadastrada");
                }

                EvolucaoEnum evolucao = dto.getConclusao().getEvolucaoCaso();

                Conclusao conclusion = new Conclusao(dto.getConclusao().isDiagnosticoImunologico(),
                        dto.getConclusao().isDiagnosticoParasitologico(),
                        dto.getConclusao().isDoencaRelacionadaAoTrabalho(), dto.getConclusao().getDataEncerramento(),
                        dto.getConclusao().getCriterioConfirmacao(), evolucao, caso);

                service.inserir(conclusion);
                return new ResponseEntity<String>(conclusion.toString(), HttpStatus.OK);

            } else {
                throw new Exception();
            }
        }catch(NullPointerException error){
            return new ResponseEntity<String>("Caso não encontrado", HttpStatus.BAD_REQUEST);
        } catch (Exception error) {
            return new ResponseEntity<String>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }



}
