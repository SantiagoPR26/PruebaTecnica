package com.example.demo.infrastructure.api.mapper.vehiculo;

import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.infrastructure.api.dto.request.vehiculo.VehiculoSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehiculoSaveRequestMapper {
    @Mapping(target = "conductor.id", source = "conductorId")
    Vehiculo toEntity(VehiculoSaveRequest vehiculoSaveRequest);
}
