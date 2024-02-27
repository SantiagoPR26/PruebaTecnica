package com.example.demo.infrastructure.api.controller;

import com.example.demo.application.conductor.ConductorSaveApplication;
import com.example.demo.domain.entities.Conductor;
import com.example.demo.infrastructure.api.dto.request.conductor.ConductorSaveRequest;
import com.example.demo.infrastructure.api.dto.response.conductor.ConductorResponse;
import com.example.demo.infrastructure.api.mapper.conductor.ConductorResponseMapper;
import com.example.demo.infrastructure.api.mapper.conductor.ConductorSaveRequestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/conductor")
@Tag(name = "Conductor")
public class ConductorController {
    private final ConductorSaveApplication conductorSaveApplication;

    private final ConductorResponseMapper conductorResponseMapper;
    private final ConductorSaveRequestMapper conductorSaveRequestMapper;


    @PostMapping("/guardar")
    @Operation(summary = "registra un conductor de la empresa")
    public ResponseEntity<ConductorResponse> saveConductor(@Valid @RequestBody ConductorSaveRequest conductorSaveRequest){
        return ResponseEntity.ok(conductorResponseMapper.toResponse(
                conductorSaveApplication.saveConductor(conductorSaveRequestMapper.toEntity(conductorSaveRequest))
        ));
    }
}
