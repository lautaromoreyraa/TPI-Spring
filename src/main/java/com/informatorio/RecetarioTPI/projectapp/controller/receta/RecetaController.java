package com.informatorio.RecetarioTPI.projectapp.controller.receta;

import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaByNombreDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaCreatedDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.service.receta.RecetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/receta")
public class RecetaController {

    private final RecetaService recetaService;

    @PostMapping()
    public ResponseEntity<?> createReceta(@RequestBody RecetaDto recetaDto) {
        try {
            RecetaDto nuevaRecetaDto = recetaService.crearReceta(recetaDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Receta " +nuevaRecetaDto.nombre()+ " creada con éxito");
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo crear la receta" + e.getMessage());
        }
    }

    @GetMapping()
    public List<RecetaCreatedDto> getAllRecetas(){
        return recetaService.getAllRecetas();
    }

    @GetMapping("/{idReceta}")
    public ResponseEntity<?> getRecetaById(@PathVariable UUID idReceta) {

        Optional<RecetaDto> recetaDto = recetaService.getRecetaByID(idReceta);

        if (recetaDto.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Receta no encontrada con el ID: " + idReceta);
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(recetaDto.get());
    }



    @GetMapping("/nombreCategoria")
    public List<CategoriaByNombreDto> getRecetaByNameCategoria(
            @RequestParam(name = "nombre") String nombreCategoria) {
        return recetaService.getAllRecetasByCategoria(nombreCategoria);
    }

    @DeleteMapping ("/{idReceta}")
    public ResponseEntity<?> deleteReceta(@PathVariable UUID idReceta) {

        boolean isRecetaDeteled = recetaService.deleteReceta ( idReceta );

        if (isRecetaDeteled) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Receta " + idReceta + " eliminada con éxito");
        }else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo eliminar la receta" + idReceta + " con el ID: " + idReceta);
        }
    }


}
