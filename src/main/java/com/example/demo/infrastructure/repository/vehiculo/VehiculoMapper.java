package com.example.demo.infrastructure.repository.vehiculo;

import com.example.demo.domain.entities.Vehiculo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface VehiculoMapper {

    Vehiculo toEntity(VehiculoDto vehiculoDto);
    List<Vehiculo> toEntity(List<VehiculoDto> vehiculoDtos);
    VehiculoDto toDto(Vehiculo vehiculo);
}
