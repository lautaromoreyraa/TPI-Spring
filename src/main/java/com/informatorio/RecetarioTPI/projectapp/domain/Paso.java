package com.informatorio.RecetarioTPI.projectapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Paso {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 5000, nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int tiempoEstimado;

    @Column(nullable = false)
    private boolean esOpcional;

    //No necesito usar mappedBy
    // porque no hay una relacion inversa en la clase Ingrediente.
    //Uso @JoinColumn para indicar que los ingredientes estan vinculados
    // a un paso especifico en la base de datos,
    // pero sin que el objeto Ingrediente tenga que almacenar esa relación.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "paso_id")
    private List<Ingrediente> ingredientes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receta_id")
    private Receta receta;
}
