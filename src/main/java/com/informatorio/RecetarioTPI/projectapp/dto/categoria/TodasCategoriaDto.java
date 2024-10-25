package com.informatorio.RecetarioTPI.projectapp.dto.categoria;

import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaResumenDto;

import java.util.List;
import java.util.UUID;

public record TodasCategoriaDto(
        UUID idCateogoria,
        String nombre,
        List<RecetaResumenDto> recetas) {}
