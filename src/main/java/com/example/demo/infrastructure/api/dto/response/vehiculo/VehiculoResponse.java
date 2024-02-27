package com.example.demo.infrastructure.api.dto.response.vehiculo;

import com.example.demo.infrastructure.repository.conductor.ConductorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoResponse {
    private Long id;
    private String modelo;
    private String placa;
    private String capacidad;
    private Long conductorId;
}
