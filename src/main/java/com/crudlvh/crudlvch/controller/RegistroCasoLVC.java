package com.crudlvh.crudlvch.controller;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
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
import com.crudlvh.crudlvch.service.RegistroServico;
import com.crudlvh.crudlvch.service.SintomaServico;

@RestController
@RequestMapping(value = "/registro")
public class RegistroCasoLVC {

  @Autowired
  private RegistroServico servico;

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
  public void salvarCasoLVC(@RequestBody CasoLVCDTO dto) {

    capturarCaso(dto);
  }

  public CasoLVC capturarCaso(CasoLVCDTO dto) {
    CasoLVC caso = new CasoLVC(dto.getDataRegistro());

    servico.inserir(caso);

    List<Sintoma> sintomas = dto.getSintomas().stream().collect(Collectors.toList());

    for (Sintoma item : sintomas) {
      Sintoma sintoma = sintomaServico.findSintomaById(item.getId());
      CasoSintoma casoSintoma = new CasoSintoma(caso, sintoma);
      casoSintomaServico.inserir(casoSintoma);
    }

    Paciente paciente = salvarPaciente(dto);

    salvarMunicipioCaso(caso, paciente, dto);

    Endereco endereco = salvarEndereco(paciente, dto);

    salvaGeoLocalizacao(endereco, dto);

    return caso;
  }

  private Paciente salvarPaciente(CasoLVCDTO dto) {
    Paciente paciente = new Paciente(dto.getPaciente().getName(), dto.getPaciente().getHiv(),
        dto.getPaciente().getTelefone(), dto.getPaciente().getNomeMae(), dto.getPaciente().getPeso(),
        dto.getPaciente().getGestante(), dto.getPaciente().getNumCartaoSus(), dto.getPaciente().getEtniaEnum(),
        dto.getPaciente().getEscolaridade(), dto.getPaciente().getSexo());
    pacienteServico.inserir(paciente);
    return paciente;
  }

  private boolean salvarMunicipioCaso(CasoLVC caso, Paciente paciente, CasoLVCDTO dto) {
    MunicipioCaso municipioCaso = new MunicipioCaso(caso, paciente, dto.getCodigoIbge());
    municipioCasoServico.inserir(municipioCaso);
    return true;
  }

  private Endereco salvarEndereco(Paciente paciente, CasoLVCDTO dto) {
    Endereco endereco = new Endereco(paciente, dto.getPaciente().getEndereco().getCodigoIBGE(),
        dto.getPaciente().getEndereco().getUF(), dto.getPaciente().getEndereco().getMunicipio(),
        dto.getPaciente().getEndereco().getCep(), dto.getPaciente().getEndereco().getZona(),
        dto.getPaciente().getEndereco().getDistrito(), dto.getPaciente().getEndereco().getBairro(),
        dto.getPaciente().getEndereco().getLogradouro(), dto.getPaciente().getEndereco().getComplemento(),
        dto.getPaciente().getEndereco().getNumeroCasa());
    enderecoServico.inserir(endereco);

    return endereco;
  }

  private void salvaGeoLocalizacao(Endereco endereco, CasoLVCDTO dto) {
    GeoLocalizacao geoLocalizacao = new GeoLocalizacao(
        dto.getPaciente().getEndereco().getGeoLocalizacao().getLatitude(),
        dto.getPaciente().getEndereco().getGeoLocalizacao().getLongitude(), endereco);
    geoLocalizacaoServico.inserir(geoLocalizacao);
  }

}
