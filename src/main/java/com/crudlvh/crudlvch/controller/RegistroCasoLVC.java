package com.crudlvh.crudlvch.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.dto.ProducerDTO;
import com.crudlvh.crudlvch.entities.CasoSintoma;
import com.crudlvh.crudlvch.entities.Endereco;
import com.crudlvh.crudlvch.entities.GeoLocalizacao;
import com.crudlvh.crudlvch.entities.MunicipioCaso;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.entities.CasoLVC;
import com.crudlvh.crudlvch.service.CasoSintomaServico;
import com.crudlvh.crudlvch.service.EnderecoServico;
import com.crudlvh.crudlvch.service.GeoLocalizacaoServico;
import com.crudlvh.crudlvch.service.MunicipioCasoServico;
import com.crudlvh.crudlvch.service.PacienteServico;
import com.crudlvh.crudlvch.service.CasoLVCServico;
import com.crudlvh.crudlvch.service.SintomaServico;

@RestController
@RequestMapping(value = "/caso")
public class RegistroCasoLVC {

  @Autowired
  private CasoLVCServico servico;

  @Autowired
  private SintomaServico sintomaServico;

  @Autowired
  private CasoSintomaServico casoSintomaServico;

  @Autowired
  private EnderecoServico enderecoServico;

  @Autowired
  private PacienteServico pacienteServico;

  @Autowired
  private GeoLocalizacaoServico geoLocalizacaoServico;

  @Autowired
  private MunicipioCasoServico municipioCasoServico;

  @PostMapping("/inserir")
  public ResponseEntity<String> salvarCasoLVC(@RequestBody CasoLVCDTO dto) {

    return capturarCaso(dto);
  }

  private void sendMessage(ProducerDTO dto) {
    servico.sendStatistic(dto);
  }

  @Transactional(rollbackOn = Exception.class)
  public ResponseEntity<String> capturarCaso(CasoLVCDTO dto) {
    CasoLVC caso = new CasoLVC(dto.getId(), dto.getDataRegistro());
    boolean codigo = dto.getCodigoIbge() == null;
    try {
      if (!codigo) {
        CasoLVC casoLVC = servico.inserir(caso);
        List<Sintoma> sintomas = dto.getSintomas().stream().collect(Collectors.toList());
        salvarSintomas(sintomas, caso);
        Paciente paciente = salvarPaciente(dto);
        salvarMunicipioCaso(caso, paciente, dto);
        Endereco endereco = salvarEndereco(paciente, dto);
        salvaGeoLocalizacao(endereco, dto);

        ProducerDTO producer = new ProducerDTO();
        producer.setCaso(casoLVC);
        producer.setPaciente(paciente);
        producer.setCodigoIbge(dto.getCodigoIbge());
        // JSONObject ja = new JSONObject(producer.toString());
        // System.out.println(producer.toString());
        sendMessage(producer);
        
        return new ResponseEntity<>("Caso registrado com sucesso", HttpStatus.OK);
      } else if (codigo) {
        throw new NullPointerException("É necessário informar o código ibge do município de contaminação");
      } else {
        throw new Exception();
      }
    } catch (NullPointerException e) {
      return new ResponseEntity<String>("" + e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  private List<CasoSintoma> salvarSintomas(List<Sintoma> sintomas, CasoLVC caso) {
    List<CasoSintoma> casosSintomas = new ArrayList<>();
    for (Sintoma item : sintomas) {
      Sintoma sintoma = sintomaServico.findSintomaById(item.getId());
      CasoSintoma casoSintoma = new CasoSintoma(caso, sintoma);

      casosSintomas.add(casoSintomaServico.inserir(casoSintoma));
    }
    return casosSintomas;
  }

  private Paciente salvarPaciente(CasoLVCDTO dto) {
    Paciente paciente = new Paciente(dto.getPaciente().getName(), dto.getPaciente().getHiv(),
        dto.getPaciente().getTelefone(), dto.getPaciente().getNomeMae(), dto.getPaciente().getPeso(),
        dto.getPaciente().getGestante(), dto.getPaciente().getNumCartaoSus(), dto.getPaciente().getEtniaEnum(),
        dto.getPaciente().getEscolaridade(), dto.getPaciente().getSexo());

    return pacienteServico.inserir(paciente);
  }

  private MunicipioCaso salvarMunicipioCaso(CasoLVC caso, Paciente paciente, CasoLVCDTO dto) {
    MunicipioCaso municipioCaso = new MunicipioCaso(caso, paciente, dto.getCodigoIbge());

    return municipioCasoServico.inserir(municipioCaso);
  }

  private Endereco salvarEndereco(Paciente paciente, CasoLVCDTO dto) {
    Endereco endereco = new Endereco(paciente, dto.getPaciente().getEndereco().getCodigoIBGE(),
        dto.getPaciente().getEndereco().getUF(), dto.getPaciente().getEndereco().getMunicipio(),
        dto.getPaciente().getEndereco().getCep(), dto.getPaciente().getEndereco().getZona(),
        dto.getPaciente().getEndereco().getDistrito(), dto.getPaciente().getEndereco().getBairro(),
        dto.getPaciente().getEndereco().getLogradouro(), dto.getPaciente().getEndereco().getComplemento(),
        dto.getPaciente().getEndereco().getNumeroCasa());

    return enderecoServico.inserir(endereco);
  }

  private void salvaGeoLocalizacao(Endereco endereco, CasoLVCDTO dto) {
    GeoLocalizacao geoLocalizacao = new GeoLocalizacao(
        dto.getPaciente().getEndereco().getGeoLocalizacao().getLatitude(),
        dto.getPaciente().getEndereco().getGeoLocalizacao().getLongitude(), endereco);
    geoLocalizacaoServico.inserir(geoLocalizacao);
  }

}
