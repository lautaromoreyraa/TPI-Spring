package com.informatorio.RecetarioTPI.projectapp.controller.categoria;

import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.TodasCategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaDto categoria){
        CategoriaDto categoriaDto = categoriaService.crearCategoria( categoria );

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body ( categoriaDto );
    }

    @GetMapping()
    public ResponseEntity<?> getAllCategoria() {
        List<TodasCategoriaDto> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

}
