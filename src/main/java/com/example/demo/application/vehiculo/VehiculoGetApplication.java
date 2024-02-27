package com.example.demo.application.vehiculo;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.domain.services.vehiculo.VehiculoGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VehiculoGetApplication {
    private final VehiculoGetService vehiculoGetService;


    public Vehiculo getById(Long id){
        return vehiculoGetService.getById(id);
    }

    public List<Vehiculo> getAll(){
        return vehiculoGetService.getAll();
    }
}
