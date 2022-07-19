package com.crudlvh.crudlvch.service;

import java.util.List;
import java.util.stream.Collectors;

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
public class CasoLVCServico implements ICasoLVCService{

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

    public CasoLVC encontrarPorId(Long id) {
        return repository.getById(id);
    }

    public void sendStatistic(ProducerDTO casoLVCDTO) {
        casoProducer.casoProducerMensagem(casoLVCDTO);
    }

    private CasoLVC inserir(CasoLVCDTO dto) {
        CasoLVC casoLVC = new CasoLVC(dto.getDataRegistro());
        return repository.save(casoLVC);
    }

    @Override
    public CasoLVC criarCaso(CasoLVCDTO dto) {
        boolean codigo = dto.getCodigoIbge() == null || dto.getCodigoIbge().equals("");
        boolean p = true;
        try{
            p = dto.getPaciente().equals(null);

        }catch(NullPointerException e){
            throw new NullPointerException("Paciente não informado");
        }
        System.out.println(codigo);
        System.out.println(p);


        if (codigo == false && !p == true){
            CasoLVC casoLVC = inserir(dto);
            List<Sintoma> sintomas = dto.getSintomas().stream().collect(Collectors.toList());
            casoSintomaServico.salvarSintomas(sintomas, casoLVC);
            Paciente paciente = pacienteServico.salvarPaciente(dto);
            municipioCasoServico.salvarMunicipioCaso(casoLVC, paciente, dto);
            Endereco endereco = enderecoServico.salvarEndereco(paciente, dto);
            geoLocalizacaoServico.salvaGeoLocalizacao(endereco, dto);

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

    private ProducerDTO createProducerDTO(CasoLVC caso, Paciente paciente, CasoLVCDTO dto) {
        ProducerDTO producer = new ProducerDTO();
        producer.setCaso(caso);
        producer.setPaciente(paciente);
        producer.setCodigoIbge(dto.getCodigoIbge());
        return producer;
    }
}
