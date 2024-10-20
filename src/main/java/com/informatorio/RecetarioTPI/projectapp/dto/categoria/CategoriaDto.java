package com.informatorio.RecetarioTPI.projectapp.dto.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;

import java.util.List;

public record CategoriaDto(
        String nombre,
        List<Receta> recetas) {}
