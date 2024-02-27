package com.example.demo.infrastructure.adapter.conductor;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.services.conductor.ConductorSaveService;
import com.example.demo.infrastructure.repository.conductor.ConductorMapper;
import com.example.demo.infrastructure.repository.conductor.ConductorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConductorSaveAdapter implements ConductorSaveService {
    private final ConductorRepository conductorRepository;
    private final ConductorMapper conductorMapper;

    @Override
    public Conductor saveConductor(Conductor conductor) {
        return conductorMapper.toEntity(conductorRepository.save(conductorMapper.toDto(conductor)));
    }
}
