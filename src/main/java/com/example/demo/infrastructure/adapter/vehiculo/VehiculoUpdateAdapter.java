package com.example.demo.infrastructure.adapter.vehiculo;

import com.example.demo.domain.services.vehiculo.VehiculoUpdateService;
import com.example.demo.infrastructure.repository.vehiculo.VehiculoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VehiculoUpdateAdapter implements VehiculoUpdateService{
    private final VehiculoRepository vehiculoRepository;

    @Transactional
    @Override
    public void updateConductor(Long conductorId, Long id) {
        vehiculoRepository.updateConductorAssociate(conductorId, id);
    }

    @Transactional
    @Override
    public void updateConductor(Long id) {
        vehiculoRepository.updateConductorDisassociate(id);
    }


}
