package com.informatorio.RecetarioTPI.projectapp.controller.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.service.receta.RecetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RecetaController {

    private RecetaService recetaService;

    @PostMapping()
    public ResponseEntity<?> createReceta(@RequestBody RecetaDto receta){
        RecetaDto recetaDto = recetaService.crearReceta(receta);

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body( recetaDto );
    }
}
