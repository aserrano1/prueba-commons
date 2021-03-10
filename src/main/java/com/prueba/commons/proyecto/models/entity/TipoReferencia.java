package com.prueba.commons.proyecto.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "tipo_referencias")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoReferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean estado;

    private String descripcion;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoReferencia", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private List<DetalleTipoReferencia> detalleTipoReferencia;

    private static final long serialVersionUID = 3062281734629764247L;

}
