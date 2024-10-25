package com.informatorio.RecetarioTPI.projectapp.dto.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Enum.DificultadEnum;
import com.informatorio.RecetarioTPI.projectapp.domain.Paso;

import java.util.List;
import java.util.UUID;

public record RecetaCreatedDto(
        UUID idReceta,
        String nombre,
        String descripcion,
        DificultadEnum dificultad,
        int tiempoPreparacion, // Este campo debe ser mutable
        UUID categoriaID,
        List<Paso> pasos) { }
