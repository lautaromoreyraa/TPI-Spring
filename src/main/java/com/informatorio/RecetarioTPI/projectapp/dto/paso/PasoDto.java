package com.informatorio.RecetarioTPI.projectapp.dto.paso;


import com.informatorio.RecetarioTPI.projectapp.domain.Ingrediente;

import java.util.List;

public record PasoDto (
        String descripcion,
        int tiempoEstimado,
        boolean esOpcional,
        List<Ingrediente> ingredientes) {}
