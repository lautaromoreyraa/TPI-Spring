package com.informatorio.RecetarioTPI.projectapp.service.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.TodasCategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.categoria.CategoriaMapper;
import com.informatorio.RecetarioTPI.projectapp.repository.categoria.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;


    @Override
    public CategoriaDto crearCategoria(CategoriaDto categoriaDto) {

        Categoria categoriaCreated = categoriaMapper.categoriaDtoToCategoria( categoriaDto );

        return categoriaMapper.categoriaToCategoriaDto( categoriaRepository.save( categoriaCreated ) );

    }


    @Override
    public Categoria getCategoriaById(UUID categoriaId) {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);

        if (categoria.isPresent()) {
            return categoria.get();
        }else {
            throw new NoSuchElementException("La categoria no existe");
        }
    }


    @Override
    public List<TodasCategoriaDto> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::todasCategoriaToTodasCategoriaDto)
                .collect(Collectors.toList()).reversed();
    }

}
