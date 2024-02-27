package com.example.demo.infrastructure.api.dto.request.conductor;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ConductorSaveRequest {
    @NotNull
    @Schema(description = "Identificacion del conductor", example = "45789879")
    @Pattern(regexp = "^(?=.{8,10}$)[0-9]+$", message = "el valor [identificacion] debe tener una longitud entre: 8 y 10 caracteres")
    private String identificacion;
    @NotNull
    @Schema(description = "Nombre del conductor")
    @Size(min = 3, max = 20, message = "El nombre debe tener maximo 20 caracteres")
    private String nombre;
    @Schema(description = "Apellido del conductor")
    @Size(min = 3, max = 20, message = "El apellido debe tener maximo 20 caracteres")
    private String apellido;
    @NotNull
    @Schema(description = "Telefono del conductor", example = "3109652283")
    @Pattern(regexp = "^[0-9]{10}$", message = "el valor [telefono] debe tener una longitud de 10 caracteres")
    private String telefono;
    private String direccion;
}
