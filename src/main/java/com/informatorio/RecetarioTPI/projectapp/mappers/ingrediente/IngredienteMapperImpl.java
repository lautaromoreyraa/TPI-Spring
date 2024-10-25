package com.informatorio.RecetarioTPI.projectapp.mappers.ingrediente;

import com.informatorio.RecetarioTPI.projectapp.domain.Ingrediente;
import com.informatorio.RecetarioTPI.projectapp.dto.ingrediente.IngredienteDto;
import org.springframework.stereotype.Component;


@Component
public class IngredienteMapperImpl implements IngredienteMapper {


    @Override
    public Ingrediente ingredienteDtoToIngrediente(IngredienteDto ingredienteDto) {
        if (ingredienteDto == null) {
            return null;
        }

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombre( ingredienteDto.nombre() );

        return ingrediente;
    }

    @Override
    public IngredienteDto ingredienteToIngredienteDto(Ingrediente ingrediente) {
        if (ingrediente == null) {
            return null;
        }

        return new IngredienteDto(ingrediente.getNombre());  // Solo devolvemos el nombre
    }
}
