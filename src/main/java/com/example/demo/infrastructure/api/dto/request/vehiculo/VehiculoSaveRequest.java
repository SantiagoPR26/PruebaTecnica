package com.example.demo.infrastructure.api.dto.request.vehiculo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VehiculoSaveRequest {
    @NotNull
    @Pattern(regexp = "[0-9]{4}$", message = "el valor [modelo] debe tener una longitud de 4 caracteres")
    private String modelo;
    @NotNull
    @Schema(description = "Placa del vehiculo", example = "HUB-769")
    @Pattern(regexp = "^[A-Z]{3}-[0-9]{3}$", message = "el valor [placa] debe tener la nomenclatura ABC-123")
    private String placa;
    @Schema(description = "La capacidad del carro debe ser en kilogramos", example = "80Kg")
    @Pattern(regexp = "^[0-9]+Kg$", message = "el valor [placa] debe tener la nomenclatura ABC-123")
    private String capacidad;
    private Long conductorId;
}
