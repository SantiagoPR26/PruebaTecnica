package com.example.demo.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Vehiculo {

    private Long id;
    private String modelo;
    private String placa;
    private String capacidad;
    private Conductor conductor;

}
