package com.informatorio.RecetarioTPI.projectapp.service.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;

import java.util.List;
import java.util.UUID;

public interface CategoriaService {
    CategoriaDto crearCategoria(CategoriaDto categoriaDto);
    Categoria getCategoriaById(UUID categoriaId);
    List<Categoria> getAllCategorias();
}
