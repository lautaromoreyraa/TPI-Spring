package com.informatorio.RecetarioTPI.projectapp.controller.categoria;

import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.TodasCategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    public ResponseEntity<?> createCategoria(@RequestBody CategoriaDto categoria){
        CategoriaDto categoriaDto = categoriaService.crearCategoria( categoria );

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body ( categoriaDto );
    }

    public ResponseEntity<?> getAllCategoria() {
    }

}
