package com.aquarius.empleadoapi.repository;

import com.aquarius.empleadoapi.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    // Puedes agregar métodos personalizados si los necesitas
}
