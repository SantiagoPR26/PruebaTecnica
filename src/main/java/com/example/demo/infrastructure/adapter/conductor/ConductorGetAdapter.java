package com.example.demo.infrastructure.adapter.conductor;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.services.conductor.ConductorGetService;
import com.example.demo.infrastructure.repository.conductor.ConductorDto;
import com.example.demo.infrastructure.repository.conductor.ConductorMapper;
import com.example.demo.infrastructure.repository.conductor.ConductorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ConductorGetAdapter implements ConductorGetService {

    private final ConductorRepository conductorRepository;
    private final ConductorMapper conductorMapper;

    @Override
    public Conductor getById(Long id) {
        Optional<ConductorDto> conductorDto = conductorRepository.findById(id);
        return conductorDto.map(conductorMapper::toEntity).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Conductor> getAll() {
        return conductorMapper.toEntity(conductorRepository.findAll());
    }
}
