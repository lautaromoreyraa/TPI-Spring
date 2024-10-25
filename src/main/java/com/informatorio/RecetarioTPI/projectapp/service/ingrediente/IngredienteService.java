package com.informatorio.RecetarioTPI.projectapp.service.ingrediente;

import com.informatorio.RecetarioTPI.projectapp.dto.ingrediente.IngredienteDto;

import java.util.List;
import java.util.UUID;

public interface IngredienteService {
    List<IngredienteDto> getIngredientesByReceta(UUID idReceta);
    List<IngredienteDto> getIngredientesByPaso(UUID idPaso);
}
