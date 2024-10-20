package com.informatorio.RecetarioTPI.projectapp.mappers.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;

public interface CategoriaMapper {
     Categoria categoriaDtoToCategoria(CategoriaDto categoriaDto);
     CategoriaDto categoriaToCategoriaDto(Categoria categoria);
}
