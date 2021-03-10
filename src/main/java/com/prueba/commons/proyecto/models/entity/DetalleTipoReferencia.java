package com.prueba.commons.proyecto.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalles_tipo_referencias")
public class DetalleTipoReferencia implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String nombre;


    private Boolean estado;

    private int orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "detalleTipoReferencia"})
    private TipoReferencia tipoReferencia;

    private static final long serialVersionUID = 9157102100653573692L;
}
