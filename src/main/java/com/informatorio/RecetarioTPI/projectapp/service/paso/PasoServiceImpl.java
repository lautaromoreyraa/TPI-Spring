package com.informatorio.RecetarioTPI.projectapp.service.paso;

import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoActualizadoDto;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.paso.PasoMapper;
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
public class PasoServiceImpl implements PasoService {

    private final PasoRepository pasoRepository;
    private final PasoMapper pasoMapper;
    private final RecetaRepository recetaRepository;


    @Override
    public List<Paso> crearPasos(List<PasoDto> pasosDto, Receta receta) {
        // Mapeamos los PasoDto a entidades Paso y asociamos la receta
        List<Paso> pasos = pasosDto.stream()
                .map(pasoDto -> {
                    Paso paso = pasoMapper.pasoDtoToPaso(pasoDto); // convierto PasoDto a Paso
                    paso.setReceta(receta); // asocio la receta ya guardada
                    return paso;
                })
                .collect(Collectors.toList());

        // guardo los pasos en la base de datos
        pasoRepository.saveAll(pasos);

        return pasos; // devuelvo la lista de Pasos ya convertidos y asociados a la receta
    }

    @Override
    public boolean updatePaso(UUID idPaso, PasoActualizadoDto pasoActualizadoDto) {
        //busco el paso por su ID dentro de la receta
        Paso paso = pasoRepository.findById(idPaso)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el paso con el ID proporcionado"));

        //actualizo los campos del paso con los datos del DTO
        Paso pasoActualizado = pasoMapper.actualizarPasoDesdeDto(pasoActualizadoDto, paso);


        //guardo los cambios en el repositorio
        pasoRepository.save(paso);

        return true; // retorno true si la operacion fue exitosa
    }

}
