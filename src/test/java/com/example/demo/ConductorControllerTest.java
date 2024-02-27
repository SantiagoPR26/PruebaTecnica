package com.example.demo;


import com.example.demo.application.conductor.ConductorSaveApplication;
import com.example.demo.domain.entities.Conductor;
import com.example.demo.infrastructure.api.controller.ConductorController;
import com.example.demo.infrastructure.api.dto.request.conductor.ConductorSaveRequest;
import com.example.demo.infrastructure.api.dto.response.conductor.ConductorResponse;
import com.example.demo.infrastructure.api.mapper.conductor.ConductorResponseMapper;
import com.example.demo.infrastructure.api.mapper.conductor.ConductorSaveRequestMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class ConductorControllerTest {
    @InjectMocks
    private ConductorController conductorController;

    @Mock
    private ConductorSaveApplication conductorSaveApplication;
    @Mock
    private ConductorSaveRequestMapper conductorSaveRequestMapper;
    @Mock
    private ConductorResponseMapper conductorResponseMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

   @BeforeEach
   void setUp() {
       this.mockMvc = MockMvcBuilders.standaloneSetup(conductorController).build();
   }

   @Test
    void saveConductorSuccess() throws Exception{
       Conductor conductor = new Conductor(
               1L,
               "123456789",
               "Santiago",
               "Pimentel",
               "3153954228",
               "Los Calamares"
       );

        ConductorResponse expectedResponse = ConductorResponse.builder()
                .id(1L)
                .identificacion("123456789")
                .nombre("Santiago")
                .apellido("Pimentel")
                .telefono("3153954228")
                .direccion("Los Calamares")
                .build();

        ConductorSaveRequest conductorInfo = ConductorSaveRequest.builder()
                .identificacion("123456789")
                .nombre("Santiago")
                .apellido("Pimentel")
                .telefono("3153954228")
                .direccion("Los Calamares")
                .build();

        String conductorInfoJson = objectMapper.writeValueAsString(conductorInfo);


        when(conductorSaveRequestMapper.toEntity(conductorInfo)).thenReturn(conductor);
        when(conductorSaveApplication.saveConductor(conductor)).thenReturn(conductor);
        when(conductorResponseMapper.toResponse(conductor)).thenReturn(expectedResponse);


        ResultActions resultActions = mockMvc.perform(post("/conductor/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(conductorInfoJson));

        resultActions.andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ConductorResponse actualResponse = objectMapper.readValue(content, ConductorResponse.class);

        assertEquals(expectedResponse, actualResponse);

   }


}


