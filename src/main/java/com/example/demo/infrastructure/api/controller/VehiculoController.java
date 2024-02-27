package com.example.demo.infrastructure.api.controller;

import com.example.demo.application.vehiculo.VehiculoSaveApplication;
import com.example.demo.infrastructure.api.dto.request.vehiculo.VehiculoSaveRequest;
import com.example.demo.infrastructure.api.dto.response.vehiculo.VehiculoResponse;
import com.example.demo.infrastructure.api.mapper.vehiculo.VehiculoResponseMapper;
import com.example.demo.infrastructure.api.mapper.vehiculo.VehiculoSaveRequestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/vehiculo")
@Tag(name = "Vehiculo")
public class VehiculoController {
    private final VehiculoSaveApplication vehiculoSaveApplication;

    private final VehiculoResponseMapper vehiculoResponseMapper;
    private final VehiculoSaveRequestMapper vehiculoSaveRequestMapper;


    @PostMapping("/guardar")
    @Operation(summary = "registra un vehiculo disponible para realizar pedidos")
    public ResponseEntity<VehiculoResponse> saveVehiculo(@RequestBody VehiculoSaveRequest vehiculoSaveRequest){
        return ResponseEntity.ok(vehiculoResponseMapper.toResponse(vehiculoSaveApplication.saveVehiculo(
                vehiculoSaveRequestMapper.toEntity(vehiculoSaveRequest)
        )));
    }
}
