package com.example.demo.infrastructure.api.mapper.conductor;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.infrastructure.api.dto.response.conductor.ConductorResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ConductorResponseMapper {

    ConductorResponse toResponse(Conductor conductor);

    List<ConductorResponse> toResponse(List<Conductor> conductors);
}
