package com.example.demo.domain.services.conductor;

import com.example.demo.domain.entities.Conductor;

import java.util.List;

public interface ConductorGetService {

    Conductor getById(Long id);
    List<Conductor> getAll();
}
