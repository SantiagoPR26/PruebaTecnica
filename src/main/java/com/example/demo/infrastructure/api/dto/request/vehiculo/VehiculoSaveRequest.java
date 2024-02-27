package com.example.demo.infrastructure.api.dto.request.vehiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoSaveRequest {
    @NotNull
    private String modelo;
    @NotNull
    private String placa;
    private String capacidad;
    private Long conductorId;
}
