package com.informatorio.RecetarioTPI.projectapp.domain;

import com.informatorio.RecetarioTPI.projectapp.domain.Enum.DificultadEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Receta {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(length = 5000, nullable = false)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private DificultadEnum dificultad;

    @Column(nullable = false)
    private int tiempoPreparacion;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "receta", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Paso> pasos;
}
