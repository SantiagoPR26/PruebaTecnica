package com.example.demo.infrastructure.repository.conductor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<ConductorDto, Long> {
}
