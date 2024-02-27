package com.example.demo.application.conductor;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.services.conductor.ConductorGetService;
import com.example.demo.domain.services.conductor.ConductorSaveService;
import com.example.demo.shared.base.ConductorExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class ConductorSaveApplication {
    private final ConductorSaveService conductorSaveService;
    private final ConductorGetService conductorGetService;

    public Conductor saveConductor(Conductor conductor) {
        if (Objects.nonNull(conductor.getIdentificacion())) {
            Conductor conductorEncontrado = conductorGetService.getAll().stream().filter(conductor1 -> conductor.getIdentificacion().equals(conductor1.getIdentificacion()))
                    .findFirst()
                    .orElse(null);

            if (conductorEncontrado != null) {
                throw new ConductorExistException(
                        "El conductor ya existe en la base de datos"
                );
            }

        }
        return conductorSaveService.saveConductor(conductor);
    }
}

