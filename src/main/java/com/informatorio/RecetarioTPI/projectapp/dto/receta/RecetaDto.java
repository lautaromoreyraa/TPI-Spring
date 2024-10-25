package com.informatorio.RecetarioTPI.projectapp.dto.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Enum.DificultadEnum;
import com.informatorio.RecetarioTPI.projectapp.domain.Paso;

import java.util.List;
import java.util.UUID;

public record RecetaDto (
        String nombre,
        String descripcion,
        DificultadEnum dificultad,
        UUID categoriaID,
        List<Paso> pasos) { }