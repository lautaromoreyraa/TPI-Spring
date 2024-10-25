package com.informatorio.RecetarioTPI.projectapp.dto.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Enum.DificultadEnum;


import java.util.UUID;

public record RecetasByCategoriaDto(
        UUID id,
        String nombre,
        DificultadEnum dificultad,
        String descripcion,
        int tiempoPreparacion) {}
