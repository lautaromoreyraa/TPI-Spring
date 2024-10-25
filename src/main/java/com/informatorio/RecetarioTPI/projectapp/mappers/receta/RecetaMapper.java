package com.informatorio.RecetarioTPI.projectapp.mappers.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaCreatedDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetasByCategoriaDto;

public interface RecetaMapper {
    Receta recetaDtoToReceta(RecetaDto recetaDto);
    RecetaDto recetaToRecetaDto(Receta receta);
    RecetaCreatedDto recetaCreatedToRecetaCreatedDto(Receta receta);
    RecetasByCategoriaDto recetaByCategoriaToRecetaByCategoriaDto(Receta receta);
}
