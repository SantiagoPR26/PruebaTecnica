package com.example.demo.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conductor {

    private Long id;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

}
