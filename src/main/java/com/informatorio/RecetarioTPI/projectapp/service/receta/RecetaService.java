package com.informatorio.RecetarioTPI.projectapp.service.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaByNombreDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaCreatedDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RecetaService {
    RecetaDto crearReceta(RecetaDto recetaDto);
    Optional<RecetaDto> getRecetaByID(UUID id);
    List<RecetaCreatedDto> getAllRecetas();
    List<CategoriaByNombreDto> getAllRecetasByCategoria(String nombre);
    CategoriaByNombreDto mapCategoriaToDto(Categoria categoria);
    int calcularTiempoTotalPreparacion(List<Paso> pasos);
    boolean deleteReceta(UUID idReceta);

    void validarSiRecetaTienePasos(RecetaDto recetaDto);
}
