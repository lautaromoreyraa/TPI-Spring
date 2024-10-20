package com.informatorio.RecetarioTPI.projectapp.service.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import com.informatorio.RecetarioTPI.projectapp.dto.categoria.CategoriaDto;
import com.informatorio.RecetarioTPI.projectapp.mappers.categoria.CategoriaMapper;
import com.informatorio.RecetarioTPI.projectapp.repository.categoria.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

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
    public List<Categoria> getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();

        if ( categorias.isEmpty() ) {
            throw new NoSuchElementException("No hay categorias disponibles");
        }else {
            return categorias;
        }
    }

}
