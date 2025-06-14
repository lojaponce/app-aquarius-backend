package com.aquarius.empleadoapi.service;

import com.aquarius.empleadoapi.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listarTodos();
    Optional<Empleado> buscarPorId(Integer id);
    Empleado guardar(Empleado empleado);
    void eliminar(Integer id);
}
