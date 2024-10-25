package com.informatorio.RecetarioTPI.projectapp.service.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaByNombreDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaCreatedDto;
import com.informatorio.RecetarioTPI.projectapp.dto.paso.PasoDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetasByCategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.paso.PasoMapper;
import com.informatorio.RecetarioTPI.projectapp.mappers.receta.RecetaMapper;
import com.informatorio.RecetarioTPI.projectapp.repository.categoria.CategoriaRepository;
import com.informatorio.RecetarioTPI.projectapp.repository.receta.RecetaRepository;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import com.informatorio.RecetarioTPI.projectapp.service.paso.PasoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RecetaServiceImpl implements RecetaService {

    private final RecetaMapper recetaMapper;
    private final RecetaRepository recetaRepository;
    private final CategoriaService categoriaService;
    private final CategoriaRepository categoriaRepository;
    private final PasoService pasoService;
    private final PasoMapper pasoMapper;


    @Override
    public RecetaDto crearReceta(RecetaDto recetaDto) {
        // valido si se insertaron los datos
        validarSiRecetaTienePasos(recetaDto);

        // obtengo el id de la categoria
        Categoria categoria = categoriaService.getCategoriaById(recetaDto.categoriaID());

        // creo la entidad Receta a partir del DTO
        Receta receta = recetaMapper.recetaDtoToReceta(recetaDto);
        receta.setCategoria(categoria); // asigno la categoría

        // guardo la receta primero para asignarle un ID
        Receta recetaGuardada = recetaRepository.save(receta);

        // llamo al metodo de creacion de pasos (pasando PasoDto)
        List<PasoDto> pasosDto = receta.getPasos().stream()
                .map(pasoMapper::pasoToPasoDto) // mapeo los objetos Paso a PasoDto
                .toList();

        //asocio los pasos a la receta ya guardada
        List<Paso> pasos = pasoService.crearPasos(pasosDto, recetaGuardada);
        recetaGuardada.setPasos(pasos);

        // llamo al metodo antes de setear el tiempo total
        int tiempoTotal = calcularTiempoTotalPreparacion(receta.getPasos());
        receta.setTiempoPreparacion(tiempoTotal);

        // devuelvo el DTO de la receta creada
        return recetaMapper.recetaToRecetaDto(recetaGuardada);
    }


    @Override
    public Optional<RecetaDto> getRecetaByID(UUID idReceta) {
        // busco la receta por su ID, si no esta retorna IllegalArgumentException
        Optional<Receta> recetaOpt = recetaRepository.findById(idReceta);

        // mapeo la receta a RecetaDto
        return recetaOpt.map(recetaMapper::recetaToRecetaDto);
    }


    @Override
    public List<RecetaCreatedDto> getAllRecetas() {
        return recetaRepository.findAll().stream()
                .map(recetaMapper::recetaCreatedToRecetaCreatedDto)
                .toList();
    }


    @Override
    public List<CategoriaByNombreDto> getAllRecetasByCategoria(String nombreCategoria) {
        if (StringUtils.hasText(nombreCategoria)) {
            List<Categoria> categorias = categoriaRepository.findAllByNombreContainingIgnoreCase(nombreCategoria);

            //valida si hay categorias con ese nombre
            if (categorias.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existen categorías que coincidan con el nombre ingresado");
            }

            //si coincide el nombre, retorna una lista de categorias
            return categorias.stream()
                    .map(this::mapCategoriaToDto)
                    .collect(Collectors.toList());
        }
        //si no hay categorias, retorna una lista vacia
        return Collections.emptyList();
    }


    @Override
    public CategoriaByNombreDto mapCategoriaToDto(Categoria categoria) {
        List<Receta> recetas = recetaRepository.findAllByCategoriaNombre(categoria.getNombre());
        List<RecetasByCategoriaDto> recetasDto = recetas.stream()
                .map(recetaMapper::recetaByCategoriaToRecetaByCategoriaDto)
                .collect(Collectors.toList());

        return new CategoriaByNombreDto(categoria.getId(), categoria.getNombre(), recetasDto);
    }


    @Override
    public int calcularTiempoTotalPreparacion(List<Paso> pasos) {
        return pasos.stream()
                .filter(paso -> !paso.isEsOpcional()) // excluye los pasos opcionales
                .mapToInt(Paso::getTiempoEstimado)
                .sum();
    }


    @Override
    public boolean deleteReceta(UUID idReceta) {

        if (recetaRepository.existsById(idReceta)) {
            recetaRepository.deleteById(idReceta);
            return true;
        }
        return false;

    }


    @Override
    public void validarSiRecetaTienePasos(RecetaDto recetaDto) {
        if (recetaDto.pasos() == null || recetaDto.pasos().isEmpty()) {
            throw new IllegalArgumentException("La receta debe tener al menos un paso.");
        }
    }



}


