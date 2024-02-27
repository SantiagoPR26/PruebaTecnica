package com.example.demo;

import com.example.demo.application.vehiculo.VehiculoSaveApplication;
import com.example.demo.application.vehiculo.VehiculoUpdateApplication;
import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.infrastructure.api.controller.VehiculoController;
import com.example.demo.infrastructure.api.dto.request.vehiculo.VehiculoSaveRequest;
import com.example.demo.infrastructure.api.dto.response.vehiculo.VehiculoResponse;
import com.example.demo.infrastructure.api.mapper.vehiculo.VehiculoResponseMapper;
import com.example.demo.infrastructure.api.mapper.vehiculo.VehiculoSaveRequestMapper;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class VehiculoControllerTest {

    @InjectMocks
    private VehiculoController vehiculoController;

    @Mock
    private VehiculoUpdateApplication vehiculoUpdateApplication;
    @Mock
    private VehiculoSaveApplication vehiculoSaveApplication;
    @Mock
    private VehiculoResponseMapper vehiculoResponseMapper;
    @Mock
    private VehiculoSaveRequestMapper vehiculoSaveRequestMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(vehiculoController).build();
    }

    @Test
    void saveVehiculoSuccess() throws Exception{
        Vehiculo vehiculo = new Vehiculo(
                1L,
                "2013",
                "GCM-123",
                "55Kg",
                null
        );

        VehiculoResponse expectedResponse = VehiculoResponse.builder()
                .id(1L)
                .modelo("2013")
                .placa("GCM-123")
                .capacidad("55Kg")
                .conductorId(null)
                .build();

        VehiculoSaveRequest vehiculoInfo = VehiculoSaveRequest.builder()
                .modelo("2013")
                .placa("GCM-123")
                .capacidad("55Kg")
                .conductorId(null)
                .build();

        String vehiculoInfoJson = objectMapper.writeValueAsString(vehiculoInfo);

        when(vehiculoSaveRequestMapper.toEntity(vehiculoInfo)).thenReturn(vehiculo);
        when(vehiculoSaveApplication.saveVehiculo(vehiculo)).thenReturn(vehiculo);
        when(vehiculoResponseMapper.toResponse(vehiculo)).thenReturn(expectedResponse);

        ResultActions resultActions = mockMvc.perform(post("/vehiculo/guardar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(vehiculoInfoJson));

        resultActions.andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        VehiculoResponse actualResponse = objectMapper.readValue(content, VehiculoResponse.class);

        assertEquals(expectedResponse, actualResponse);

    }

    @Test
    void updateVehiculoAssociate() throws Exception {
        Long conductorId = 1L;
        Long id = 2L;

        mockMvc.perform(put("/vehiculo/asociarConductor")
                        .param("conductorId", conductorId.toString())
                        .param("id", id.toString()))
                .andExpect(status().isOk());
        verify(vehiculoUpdateApplication).updateConductor(conductorId, id);
    }

    @Test
    void updateVehiculoDisassociate() throws Exception {
        Long id = 2L;

        mockMvc.perform(put("/vehiculo/desasociarConductor")
                        .param("id", id.toString()))
                .andExpect(status().isOk());
        verify(vehiculoUpdateApplication).updateConductor(id);
    }


}
