package com.aquarius.empleadoapi.service;

import com.aquarius.empleadoapi.model.Empleado;
import com.aquarius.empleadoapi.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> listarTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Optional<Empleado> buscarPorId(Integer id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
