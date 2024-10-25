package com.informatorio.RecetarioTPI.projectapp.service.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import com.informatorio.RecetarioTPI.projectapp.dto.receta.RecetaDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.receta.RecetaMapper;
import com.informatorio.RecetarioTPI.projectapp.repository.receta.RecetaRepository;
import com.informatorio.RecetarioTPI.projectapp.service.categoria.CategoriaService;
import org.springframework.stereotype.Service;


@Service
public class RecetaServiceImpl implements RecetaService {

    private final RecetaMapper recetaMapper;
    private final RecetaRepository recetaRepository;
    private final CategoriaService categoriaService;


    @Override
    public RecetaDto crearReceta(RecetaDto recetaDto) {
        Categoria categoria = categoriaService.getCategoriaById(recetaDto.categoriaID());


    }

    @Override
        }
    }

