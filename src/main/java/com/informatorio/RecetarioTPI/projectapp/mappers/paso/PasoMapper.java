package com.informatorio.RecetarioTPI.projectapp.mappers.paso;

import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoActualizadoDto;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoDto;

public interface PasoMapper {
    Paso pasoDtoToPaso(PasoDto pasoDto);
    PasoDto pasoToPasoDto(Paso paso);
    Paso actualizarPasoDesdeDto(PasoActualizadoDto pasoActualizadoDto, Paso paso);
}
