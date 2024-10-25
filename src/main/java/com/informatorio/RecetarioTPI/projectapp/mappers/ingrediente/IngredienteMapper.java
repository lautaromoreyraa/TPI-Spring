package com.informatorio.RecetarioTPI.projectapp.mappers.ingrediente;

import com.informatorio.RecetarioTPI.projectapp.domain.Ingrediente;
import com.informatorio.RecetarioTPI.projectapp.dto.ingrediente.IngredienteDto;
import org.springframework.stereotype.Component;


@Component
public interface IngredienteMapper {
    Ingrediente ingredienteDtoToIngrediente(IngredienteDto ingredienteDto);
    IngredienteDto ingredienteToIngredienteDto(Ingrediente ingrediente);
}
