package com.informatorio.RecetarioTPI.projectapp.mappers.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaCreatedDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetasByCategoriaDto;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class RecetaMapperImpl implements RecetaMapper {

    @Override
    public Receta recetaDtoToReceta(RecetaDto recetaDto) {
        Receta recetaCreate = new Receta();

        recetaCreate.setId(UUID.randomUUID());
        recetaCreate.setNombre(recetaDto.nombre());
        recetaCreate.setDescripcion(recetaDto.descripcion());
        recetaCreate.setDificultad(recetaDto.dificultad());

        // No asgino el tiempo de preparacion ni el ID de categoria,
        // eso lo hago en RecetaServiceImpl. -> PUEDE SER QUE POR ESTO NO ME TOMA EL TIEMPO TOTAL DE LA RECETA.

        recetaCreate.setPasos(recetaDto.pasos());
        return recetaCreate;
    }

    @Override
    public RecetaDto recetaToRecetaDto(Receta receta) {
        return new RecetaDto(
                receta.getNombre(),
                receta.getDescripcion(),
                receta.getDificultad(),
                receta.getTiempoPreparacion(),
                receta.getCategoria().getId(),  // obtengo el ID de la categoría
                receta.getPasos()
        );
    }

    @Override
    public RecetaCreatedDto recetaCreatedToRecetaCreatedDto(Receta receta){
        return new RecetaCreatedDto(
                receta.getId(),
                receta.getNombre(),
                receta.getDescripcion(),
                receta.getDificultad(),
                receta.getTiempoPreparacion(),
                receta.getCategoria().getId(),  // obtengo el ID de la categoría
                receta.getPasos()
        );
    }

    @Override
    public RecetasByCategoriaDto recetaByCategoriaToRecetaByCategoriaDto(Receta receta) {
        return new RecetasByCategoriaDto(
                receta.getId(),
                receta.getNombre(),
                receta.getDificultad(),
                receta.getDescripcion(),
                receta.getTiempoPreparacion());
    }


}
