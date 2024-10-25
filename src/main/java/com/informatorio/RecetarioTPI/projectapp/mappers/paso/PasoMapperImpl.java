package com.informatorio.RecetarioTPI.projectapp.mappers.paso;

import com.informatorio.RecetarioTPI.projectapp.domain.Ingrediente;
import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoActualizadoDto;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.ingrediente.IngredienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PasoMapperImpl implements PasoMapper {

    private final IngredienteMapper ingredienteMapper;



    @Override
    public Paso pasoDtoToPaso(PasoDto pasoDto) {
        if (pasoDto == null) {
            return null;
        }

        Paso paso = new Paso();
        paso.setId( UUID.randomUUID() );
        paso.setDescripcion(pasoDto.descripcion());
        paso.setTiempoEstimado(pasoDto.tiempoEstimado());
        paso.setEsOpcional(pasoDto.esOpcional());
        paso.setIngredientes( pasoDto.ingredientes() );

        return paso;
    }

    @Override
    public PasoDto pasoToPasoDto(Paso paso) {
        if (paso == null) {
            return null;
        }

        return new PasoDto(
                paso.getDescripcion(),
                paso.getTiempoEstimado(),
                paso.isEsOpcional(),
                paso.getIngredientes()
        );
    }

    @Override
    public Paso actualizarPasoDesdeDto(PasoActualizadoDto dto, Paso paso) {
        paso.setDescripcion(dto.descripcion());
        paso.setTiempoEstimado(dto.tiempoEstimado());
        paso.setEsOpcional(dto.esOpcional());

        // convierto la lista de IngredienteDto a objetos Ingrediente

        List<Ingrediente> ingredientes = dto.ingredientes().stream()
                .map(ingredienteMapper::ingredienteDtoToIngrediente) // mapeo cada IngredienteDto a un Ingrediente
                .collect(Collectors.toList());

        paso.setIngredientes(ingredientes); // actualizo ingredientes del paso
        return paso;
    }


}
