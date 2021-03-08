package com.prueba.commons.proyecto.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(catalog = "departamentos")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private static final long serialversionUID = 1l;

    @Column(unique = true, nullable = false)
    private String codigo;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "name", "codigo"})
    private Pais pais;

}
