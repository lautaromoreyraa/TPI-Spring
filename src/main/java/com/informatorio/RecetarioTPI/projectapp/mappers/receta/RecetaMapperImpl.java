package com.informatorio.RecetarioTPI.projectapp.mappers.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RecetaMapperImpl implements RecetaMapper {

    private final CategoriaService categoriaService;

    public RecetaMapperImpl(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Override
    public Receta recetaDtoToReceta(RecetaDto recetaDto) {
        Receta recetaCreate = new Receta();
        recetaCreate.setId(UUID.randomUUID());
        recetaCreate.setNombre(recetaDto.nombre());
        recetaCreate.setDescripcion(recetaDto.descripcion());
        recetaCreate.setDificultad(recetaDto.dificultad());
        recetaCreate.setTiempoPreparacion(recetaDto.tiempoPreparacion());

        // Aquí ya no asignamos el ID directamente, eso lo hacemos en el servicio
        // recetaCreate.setCategoria ( recetaDto.categoriaID() );

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
                receta.getCategoria().getId(),  // Obtener el ID de la categoría
                receta.getPasos()
        );
    }
}
