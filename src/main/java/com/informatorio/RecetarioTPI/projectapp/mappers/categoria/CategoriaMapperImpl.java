package com.informatorio.RecetarioTPI.projectapp.mappers.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.TodasCategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaResumenDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {
    @Override
    public Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        categoria.setId( UUID.randomUUID() );
        categoria.setNombre( categoriaDto.nombre() );
        return categoria;
    }

    @Override
    public CategoriaDto categoriaToCategoriaDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getRecetas()
        );
    }

    @Override
    public TodasCategoriaDto todasCategoriaToTodasCategoriaDto(Categoria categoria) {
        // Convertir las recetas de la categoría a RecetaResumenDto
        List<RecetaResumenDto> recetas = categoria.getRecetas().stream()
                .map(receta -> new RecetaResumenDto(receta.getId(), receta.getNombre()))
                .collect(Collectors.toList());

        return new TodasCategoriaDto (categoria.getId() , categoria.getNombre(), recetas);
    }
}
