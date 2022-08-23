package com.crudlvh.crudlvch.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.dto.ProducerDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.Endereco;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.interfaces.ICasoLVCService;
import com.crudlvh.crudlvch.producer.CasoProducer;
import com.crudlvh.crudlvch.repositories.CasoLVCRepository;
import com.crudlvh.crudlvch.repositories.CasoSintomaRepository;

@Service
public class CasoLVCServico implements ICasoLVCService {

    @Autowired
    private CasoProducer casoProducer;

    @Autowired
    private CasoLVCRepository repository;

    @Autowired
    private CasoSintomaRepository casoSintomaRepository;

    @Autowired
    private CasoSintomaServico casoSintomaServico;

    @Autowired
    private PacienteServico pacienteServico;

    @Autowired
    private MunicipioCasoServico municipioCasoServico;

    @Autowired
    private EnderecoServico enderecoServico;

    @Autowired
    private GeoLocalizacaoServico geoLocalizacaoServico;

    public void inserirCasoSintoma(CasoSintoma casoSintoma) {
        casoSintomaRepository.save(casoSintoma);
    }

    private CasoLVC inserir(CasoLVCDTO dto) {
        CasoLVC casoLVC = new CasoLVC(dto.retornarDataRegistro());
        return repository.save(casoLVC);
    }
    

    // Classe responsável por registrar o caso
    // Obs. O ideal é que o usuário possa preencher mais de um paciente por caso, necessitando fazer alterações nas classes Caso, Conclusão, Sintoma e Tratamento.
    @Override
    @Transactional(rollbackOn = ConstraintViolationException.class)
    public CasoLVC registrarCaso(CasoLVCDTO dto) {
        boolean codigo = false;

        try {
            codigo = dto.retornarCodigoIbge() == null || dto.retornarCodigoIbge().equals("");
        } catch (NullPointerException e) {
            throw new NullPointerException("Código Ibge não informado");
        }

        boolean p = true;

        try {
            p = dto.retornarPaciente().equals(null);
            
        } catch (NullPointerException e) {
            throw new NullPointerException("Paciente não informado");
        }
        
        if (codigo == false && !p == true) {
            CasoLVC casoLVC = inserir(dto);
            List<Sintoma> sintomas = dto.retornarSintomas().stream().collect(Collectors.toList());
            casoSintomaServico.salvarSintomas(sintomas, casoLVC);
            Paciente paciente = pacienteServico.salvarPaciente(dto);
            municipioCasoServico.salvarMunicipioCaso(casoLVC, paciente, dto);
            Endereco endereco = enderecoServico.salvarEndereco(paciente, dto);
            geoLocalizacaoServico.salvaGeoLocalizacao(endereco, dto);
            
            // Dto
            ProducerDTO producer = createProducerDTO(casoLVC, paciente, dto);
            
            sendStatistic(producer);
            return repository.save(casoLVC);
        } else {
            throw new NullPointerException("Código IBGE não informado");
        }
    }
    
    public List<CasoLVC> listarCasos() {
        return repository.findAll();
    }
    
    public CasoLVC encontrarPorId(Long id) {
        return repository.getById(id);
    }

    private ProducerDTO createProducerDTO(CasoLVC caso, Paciente paciente, CasoLVCDTO dto) {
        ProducerDTO producer = new ProducerDTO();
        producer.definirCaso(caso);
        producer.definirPaciente(paciente);
        producer.definirCodigoIbge(dto.retornarCodigoIbge());
        return producer;
    }
    
    // Método responsável por invocar a producer enviar o caso para outro microsserviço.
    // Invocada durante o registro de um caso
    public void sendStatistic(ProducerDTO casoLVCDTO) {
        casoProducer.casoProducerMensagem(casoLVCDTO);
    }
    
}
