package com.informatorio.RecetarioTPI.projectapp.dto.categoria;

import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetasByCategoriaDto;

import java.util.List;
import java.util.UUID;

public record CategoriaByNombreDto(
        UUID id,
        String nombre,
        List<RecetasByCategoriaDto> recetas
) { }
