package com.aquarius.empleadoapi.service;

import com.aquarius.empleadoapi.model.Area;
import com.aquarius.empleadoapi.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository;

    @Override
    public List<Area> listarTodas() {
        return areaRepository.findAll();
    }

    @Override
    public Optional<Area> buscarPorId(Integer id) {
        return areaRepository.findById(id);
    }

    @Override
    public Area guardar(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public void eliminar(Integer id) {
        areaRepository.deleteById(id);
    }
}
