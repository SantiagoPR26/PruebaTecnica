package com.example.demo.infrastructure.repository.vehiculo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoDto, Long> {
    @Query("SELECT COUNT(vd)>0 FROM VehiculoDto vd WHERE vd.placa=:placa")
    boolean placaExist(String placa);

    @Query("UPDATE VehiculoDto bd SET bd.conductor.id = :conductorId" +
            " WHERE bd.id = :id")
    @Modifying
    void updateConductorAssociate(Long conductorId, Long id);

    @Query("UPDATE VehiculoDto bd SET bd.conductor.id = NULL" +
            " WHERE bd.id = :id")
    @Modifying
    void updateConductorDisassociate(Long id);

}
