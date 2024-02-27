package com.example.demo.infrastructure.repository.conductor;

import com.example.demo.domain.entities.Conductor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ConductorMapper {

    Conductor toEntity(ConductorDto conductorDto);

    ConductorDto toDto(Conductor conductor);

    List<Conductor> toEntity(List<ConductorDto> conductors);
}
