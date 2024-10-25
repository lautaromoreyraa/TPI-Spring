package com.informatorio.RecetarioTPI.projectapp.repository.categoria;

import com.informatorio.RecetarioTPI.projectapp.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
    List<Categoria> findAllByNombreContainingIgnoreCase(String nombre);
}
