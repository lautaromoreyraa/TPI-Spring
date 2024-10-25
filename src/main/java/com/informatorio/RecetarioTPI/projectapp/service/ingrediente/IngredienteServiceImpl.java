package com.informatorio.RecetarioTPI.projectapp.service.ingrediente;

import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.ingrediente.IngredienteDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.ingrediente.IngredienteMapper;
import com.informatorio.RecetarioTPI.projectapp.repository.paso.PasoRepository;
import com.informatorio.RecetarioTPI.projectapp.repository.receta.RecetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class IngredienteServiceImpl implements IngredienteService {

    private final RecetaRepository recetaRepository;
    private final PasoRepository pasoRepository;
    private final IngredienteMapper ingredienteMapper;


    @Override
    public List<IngredienteDto> getIngredientesByReceta(UUID idReceta) {
        Receta receta = recetaRepository.findById(idReceta)
                .orElseThrow(() -> new NoSuchElementException("Receta no encontrada"));

        // obtengo los ingredientes de todos los pasos y los mappeo a DTO
        return receta.getPasos().stream()
                .flatMap(paso -> paso.getIngredientes().stream())
                .map(ingredienteMapper::ingredienteToIngredienteDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<IngredienteDto> getIngredientesByPaso(UUID idPaso) {
        Paso paso = pasoRepository.findById(idPaso)
                .orElseThrow(() -> new NoSuchElementException("Paso no encontrado"));

        return paso.getIngredientes().stream()
                .map(ingredienteMapper::ingredienteToIngredienteDto)
                .collect(Collectors.toList());
    }

}
