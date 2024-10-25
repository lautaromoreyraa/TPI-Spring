package com.informatorio.RecetarioTPI.projectapp.dto.paso;

import com.informatorio.RecetarioTPI.projectapp.dto.ingrediente.IngredienteDto;

import java.util.List;

public record PasoActualizadoDto(
        String descripcion,
        int tiempoEstimado,
        boolean esOpcional,
        List<IngredienteDto> ingredientes) {}
