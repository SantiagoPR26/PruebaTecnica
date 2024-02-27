package com.example.demo.application.vehiculo;

import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.domain.services.vehiculo.VehiculoSaveService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VehiculoSaveApplication {
    private final VehiculoSaveService vehiculoSaveService;

    public Vehiculo saveVehiculo(Vehiculo vehiculo){
        return vehiculoSaveService.saveVehiculo(vehiculo);
    }
}
