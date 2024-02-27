package com.example.demo.infrastructure.repository.vehiculo;

import com.example.demo.infrastructure.repository.conductor.ConductorDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "VEHICULO")
public class VehiculoDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "placa")
    private String placa;
    @Column(name = "capacidad")
    private String capacidad;
    @ManyToOne
    @JoinColumn(name = "conductor_id", referencedColumnName = "id", nullable = true)
    private ConductorDto conductor;
}
