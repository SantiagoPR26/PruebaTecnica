package com.example.demo.infrastructure.api.dto.response.conductor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConductorResponse {
    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
}
