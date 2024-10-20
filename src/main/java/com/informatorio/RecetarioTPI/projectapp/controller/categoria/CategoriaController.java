package com.informatorio.RecetarioTPI.projectapp.controller.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.TodasCategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping( "api/categoria" )
    public ResponseEntity<?> createCategoria(@RequestBody CategoriaDto categoria){
        CategoriaDto categoriaDto = categoriaService.crearCategoria(categoria);

        return ResponseEntity
                .status( HttpStatus.CREATED )
                .body ( categoriaDto );
    }

    @GetMapping( "api/categoria" )
    public ResponseEntity<?> getAllCategoria(){
        List<Categoria> categoriaDto = categoriaService.getAllCategorias();

        return ResponseEntity.ok ( categoriaDto );
    }

}
