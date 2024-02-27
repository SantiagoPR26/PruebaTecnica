package com.example.demo.infrastructure.repository.vehiculo;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.infrastructure.repository.conductor.ConductorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface VehiculoMapper {

    Vehiculo toEntity(VehiculoDto vehiculoDto);
    List<Vehiculo> toEntity(List<VehiculoDto> vehiculoDtos);
    @Mapping(target = "conductor", qualifiedByName = "mapConductor")
    VehiculoDto toDto(Vehiculo vehiculo);
    @Named("mapConductor")
    static ConductorDto mapConductor(Conductor conductor){
      if (conductor == null || conductor.getId() == null){
        return null;
      }
      ConductorDto conductorDto = new ConductorDto();
      conductorDto.setId(conductor.getId());
      return conductorDto;
    }
}
