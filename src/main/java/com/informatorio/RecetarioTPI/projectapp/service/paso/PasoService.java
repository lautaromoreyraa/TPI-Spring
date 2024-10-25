package com.informatorio.RecetarioTPI.projectapp.service.paso;

import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoActualizadoDto;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoDto;

import java.util.List;
import java.util.UUID;


public interface PasoService {
    List<Paso> crearPasos(List<PasoDto> pasosDto, Receta receta);
    boolean updatePaso(UUID idPaso, PasoActualizadoDto pasoActualizadoDto);
}
