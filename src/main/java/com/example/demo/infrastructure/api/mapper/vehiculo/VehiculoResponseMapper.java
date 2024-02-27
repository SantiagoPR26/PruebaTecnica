package com.example.demo.infrastructure.api.mapper.vehiculo;

import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.infrastructure.api.dto.response.vehiculo.VehiculoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface VehiculoResponseMapper {
    @Mapping(target = "conductorId", source = "conductor.id")
    VehiculoResponse toResponse(Vehiculo vehiculo);

    List<VehiculoResponse> toResponse(List<Vehiculo> vehiculos);
}
