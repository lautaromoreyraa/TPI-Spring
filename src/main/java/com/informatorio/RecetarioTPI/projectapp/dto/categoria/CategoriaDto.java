package com.informatorio.RecetarioTPI.projectapp.dto.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;

import java.util.List;
import java.util.UUID;

public record CategoriaDto(
        UUID idCategoria,
        String nombre,
        List<Receta> recetas) {}
