package com.example.demo.infrastructure.api.dto.response.vehiculo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehiculoResponse {
    private Long id;
    private String modelo;
    private String placa;
    private String capacidad;
    private Long conductorId;
}
