package com.informatorio.RecetarioTPI.projectapp.repository.paso;

import com.informatorio.RecetarioTPI.projectapp.domain.Paso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasoRepository extends JpaRepository<Paso, UUID> {
}
