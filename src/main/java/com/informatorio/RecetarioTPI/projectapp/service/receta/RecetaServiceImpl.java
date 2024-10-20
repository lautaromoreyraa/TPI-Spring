package com.informatorio.RecetarioTPI.projectapp.service.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.receta.RecetaMapper;
import com.informatorio.RecetarioTPI.projectapp.repository.receta.RecetaRepository;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecetaServiceImpl implements RecetaService {

    private final RecetaMapper recetaMapper;
    private final RecetaRepository recetaRepository;
    private final CategoriaService categoriaService;

    public RecetaServiceImpl(RecetaMapper recetaMapper, RecetaRepository recetaRepository, CategoriaService categoriaService) {
        this.recetaMapper = recetaMapper;
        this.recetaRepository = recetaRepository;
        this.categoriaService = categoriaService;
    }

    @Override
    public RecetaDto crearReceta(RecetaDto recetaDto) {
        // Obtener la categoría por ID
        Categoria categoria = categoriaService.getCategoriaById(recetaDto.categoriaID());

        // Mapear la receta con el DTO y asignar la categoría obtenida
        Receta recetaCreated = recetaMapper.recetaDtoToReceta(recetaDto);
        recetaCreated.setCategoria(categoria);

        // Guardar la receta y devolver el DTO
        return recetaMapper.recetaToRecetaDto(recetaRepository.save(recetaCreated));
    }

    @Override
    public Receta getRecetaByID(UUID id) {
        Optional<Receta> optionalReceta = recetaRepository.findById(id);
        return optionalReceta.orElseThrow(() -> new NoSuchElementException("La receta no existe"));
    }
}

