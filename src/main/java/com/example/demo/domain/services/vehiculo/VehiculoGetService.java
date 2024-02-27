package com.example.demo.domain.services.vehiculo;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.entities.Vehiculo;

import java.util.List;

public interface VehiculoGetService {

    Vehiculo getById(Long id);

    List<Vehiculo> getAll();
}
