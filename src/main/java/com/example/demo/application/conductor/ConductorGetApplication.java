package com.example.demo.application.conductor;

import com.example.demo.domain.entities.Conductor;
import com.example.demo.domain.services.conductor.ConductorGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ConductorGetApplication {
    private final ConductorGetService conductorGetService;

    public Conductor getById(Long id){
        return conductorGetService.getById(id);
    }

    public List<Conductor> getAll(){
        return conductorGetService.getAll();
    }
}
