package com.informatorio.RecetarioTPI.projectapp.mappers.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapperImpl implements CategoriaMapper {
    @Override
    public Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        categoria.setNombre( categoriaDto.nombre() );
        return categoria;
    }

    @Override
    public CategoriaDto categoriaToCategoriaDto(Categoria categoria) {
        return new CategoriaDto(
                categoria.getNombre(),
                categoria.getRecetas()
        );
    }
}
