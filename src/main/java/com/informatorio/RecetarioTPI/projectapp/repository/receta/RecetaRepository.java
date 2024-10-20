package com.informatorio.RecetarioTPI.projectapp.repository.receta;

import com.informatorio.RecetarioTPI.projectapp.domain.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecetaRepository extends JpaRepository<Receta, UUID> {
}
