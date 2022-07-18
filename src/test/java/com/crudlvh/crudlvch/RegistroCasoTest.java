package com.crudlvh.crudlvch;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.crudlvh.crudlvch.controller.RegistroCasoLVC;
import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.EtniaEnum;
import com.crudlvh.crudlvch.entities.Paciente;
import com.crudlvh.crudlvch.entities.Sintoma;
import com.crudlvh.crudlvch.service.CasoLVCServico;
import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles("test")
@WebMvcTest(controllers = RegistroCasoLVC.class)
@AutoConfigureMockMvc
public class RegistroCasoTest {

    static final String URL = "/caso";
    static final MediaType JSON = MediaType.APPLICATION_JSON;

    @Autowired
    MockMvc mvc;

    @MockBean
    CasoLVCServico servico;

    @Test
    public void criarCaso() throws Exception {

        Date d = new GregorianCalendar(2001, 2 - 1, 6).getTime();
        String codigoIbge = null;
        Long l = (long) 1;
        Sintoma s = new Sintoma(l, "Febre");
        List<Sintoma> sintomas = new ArrayList<Sintoma>();
        sintomas.add(s);
        Float peso = (float) 80;
        Long numCartaoSus = (long) 1111111111;

        Paciente p = new Paciente(
                "test-spring",
                false, "62992417500",
                "mãe teste-spring",
                peso,
                false,
                numCartaoSus,
                EtniaEnum.valueOf("Branca"),
                "Ensino Médio",
                "Masculino");

        CasoLVCDTO dto = new CasoLVCDTO(d, codigoIbge, sintomas, p);

        String json = new ObjectMapper().writeValueAsString(dto);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(URL.concat("/inserir"))
                .accept(JSON)
                .contentType(JSON)
                .content(json);

        when(servico.criarCaso(dto)).thenThrow(NullPointerException.class);

        MvcResult result = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        // assertEquals("200", actual);
    }
}
