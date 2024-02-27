package com.example.demo.infrastructure.api.controller;

import com.example.demo.application.vehiculo.VehiculoSaveApplication;
import com.example.demo.application.vehiculo.VehiculoUpdateApplication;
import com.example.demo.infrastructure.api.dto.request.vehiculo.VehiculoSaveRequest;
import com.example.demo.infrastructure.api.dto.response.vehiculo.VehiculoResponse;
import com.example.demo.infrastructure.api.mapper.vehiculo.VehiculoResponseMapper;
import com.example.demo.infrastructure.api.mapper.vehiculo.VehiculoSaveRequestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/vehiculo")
@Tag(name = "Vehiculo")
public class VehiculoController {
    private final VehiculoSaveApplication vehiculoSaveApplication;
    private final VehiculoUpdateApplication vehiculoUpdateApplication;

    private final VehiculoResponseMapper vehiculoResponseMapper;
    private final VehiculoSaveRequestMapper vehiculoSaveRequestMapper;


    @PostMapping("/guardar")
    @Operation(summary = "registra un vehiculo disponible para realizar pedidos")
    public ResponseEntity<VehiculoResponse> saveVehiculo(@RequestBody @Valid VehiculoSaveRequest vehiculoSaveRequest){
        return ResponseEntity.ok(vehiculoResponseMapper.toResponse(vehiculoSaveApplication.saveVehiculo(
                vehiculoSaveRequestMapper.toEntity(vehiculoSaveRequest)
        )));
    }

    @PutMapping("/asociarConductor")
    @Operation(summary = "asocia un vehiculo a un conductor")
    public void updateConductor(@RequestParam("conductorId") Long conductorId,@RequestParam("id") Long id){
        vehiculoUpdateApplication.updateConductor(conductorId, id);
    }

    @PutMapping("/desasociarConductor")
    @Operation(summary = "desasocia un vehiculo de un conductor")
    public void   updateConductor(@RequestParam("id") Long id){
        vehiculoUpdateApplication.updateConductor(id);
    }

}
