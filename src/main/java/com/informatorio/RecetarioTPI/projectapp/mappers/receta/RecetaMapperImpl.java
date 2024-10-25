package com.informatorio.RecetarioTPI.projectapp.mappers.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
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
                receta.getPasos()
        );
    }
}
