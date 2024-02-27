package com.example.demo.infrastructure.adapter.vehiculo;

import com.example.demo.domain.entities.Vehiculo;
import com.example.demo.domain.services.vehiculo.VehiculoGetService;
import com.example.demo.infrastructure.repository.vehiculo.VehiculoDto;
import com.example.demo.infrastructure.repository.vehiculo.VehiculoMapper;
import com.example.demo.infrastructure.repository.vehiculo.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VehiculoGetAdapter implements VehiculoGetService {
    private final VehiculoRepository vehiculoRepository;
    private final VehiculoMapper vehiculoMapper;

    public Vehiculo getById(Long id){
        Optional<VehiculoDto> vehiculoDto = vehiculoRepository.findById(id);
        return vehiculoDto.map(vehiculoMapper::toEntity).orElseThrow(RuntimeException::new);
    }

    public List<Vehiculo> getAll(){
        return vehiculoMapper.toEntity(vehiculoRepository.findAll());
    }
}
