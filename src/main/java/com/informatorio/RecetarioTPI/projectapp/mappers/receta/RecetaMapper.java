package com.informatorio.RecetarioTPI.projectapp.mappers.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;

public interface RecetaMapper {
    Receta recetaDtoToReceta(RecetaDto recetaDto);
    RecetaDto recetaToRecetaDto(Receta receta);
}
