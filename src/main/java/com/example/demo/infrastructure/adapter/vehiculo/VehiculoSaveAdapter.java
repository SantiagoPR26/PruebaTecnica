package com.example.demo.infrastructure.adapter.vehiculo;

import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.domain.services.vehiculo.VehiculoSaveService;
import com.example.demo.infrastructure.repository.vehiculo.VehiculoMapper;
import com.example.demo.infrastructure.repository.vehiculo.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VehiculoSaveAdapter implements VehiculoSaveService {
    private final VehiculoRepository vehiculoRepository;
    private final VehiculoMapper vehiculoMapper;

    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoMapper.toEntity(vehiculoRepository.save(vehiculoMapper.toDto(vehiculo)));
    }
}
