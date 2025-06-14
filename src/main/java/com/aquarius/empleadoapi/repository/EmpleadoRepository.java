package com.aquarius.empleadoapi.repository;

import com.aquarius.empleadoapi.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    // Ejemplo: List<Empleado> findByAreaCodigo(Integer areaCodigo);
}
