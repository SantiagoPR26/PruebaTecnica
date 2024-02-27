package com.example.demo.application.vehiculo;

import com.example.demo.domain.services.vehiculo.VehiculoUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VehiculoUpdateApplication {
    private final VehiculoUpdateService vehiculoUpdateService;

    public void updateConductor(Long conductorId, Long id){
        vehiculoUpdateService.updateConductor(conductorId, id);
    }

    public void updateConductor(Long id){
        vehiculoUpdateService.updateConductor(id);
    }
}
