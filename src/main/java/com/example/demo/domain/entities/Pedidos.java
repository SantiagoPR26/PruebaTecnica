package com.example.demo.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedidos {

    private Long id;
    private String tipoPedido;
    private String direccion;
    private Conductor conductor;
}
