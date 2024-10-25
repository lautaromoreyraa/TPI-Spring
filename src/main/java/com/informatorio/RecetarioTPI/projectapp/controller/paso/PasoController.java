package com.informatorio.RecetarioTPI.projectapp.controller.paso;

import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoActualizadoDto;
import com.informatorio.RecetarioTPI.projectapp.service.paso.PasoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/paso")
public class PasoController {

    PasoService pasoService;

    @PutMapping("/{idPaso}")
    public ResponseEntity<?> updatePaso(
            @PathVariable UUID idPaso,
            @RequestBody PasoActualizadoDto pasoActualizadoDto) {

        // Llamo al servicio para actualizar el paso
        boolean pasoActualizado = pasoService.updatePaso(idPaso, pasoActualizadoDto);

        // Si la actualización fue exitosa, devuelvo una respuesta adecuada
        if (pasoActualizado) {
            return ResponseEntity.ok("El paso fue actualizado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El paso no fue encontrado.");
        }
    }


}
