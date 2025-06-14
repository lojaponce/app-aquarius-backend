package com.aquarius.empleadoapi.service;

import com.aquarius.empleadoapi.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {
    List<Area> listarTodas();
    Optional<Area> buscarPorId(Integer id);
    Area guardar(Area area);
    void eliminar(Integer id);
}
