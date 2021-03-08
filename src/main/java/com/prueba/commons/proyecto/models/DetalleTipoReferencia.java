package com.prueba.commons.proyecto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalles_tipo_referencias")
public class DetalleTipoReferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
