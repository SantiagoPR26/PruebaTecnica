package com.example.demo.infrastructure.api.mapper.conductor;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.infrastructure.api.dto.request.conductor.ConductorSaveRequest;
import org.mapstruct.Mapper;

@Mapper
public interface ConductorSaveRequestMapper {

    Conductor toEntity(ConductorSaveRequest conductorSaveRequest);
}
