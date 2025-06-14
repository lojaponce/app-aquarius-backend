package com.aquarius.empleadoapi.controller;

import com.aquarius.empleadoapi.model.Area;
import com.aquarius.empleadoapi.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "*") // Habilita CORS
public class    AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<Area> listarTodas() {
        return areaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> obtenerPorId(@PathVariable Integer id) {
        return areaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Area crear(@RequestBody Area area) {
        return areaService.guardar(area);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> actualizar(@PathVariable Integer id, @RequestBody Area area) {
        return areaService.buscarPorId(id)
                .map(aExistente -> {
                    aExistente.setNombre(area.getNombre());
                    return ResponseEntity.ok(areaService.guardar(aExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        return areaService.buscarPorId(id).map(area -> {
            areaService.eliminar(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/")
    public String home() {
        return "API Empleado corriendo correctamente.";
    }
}
