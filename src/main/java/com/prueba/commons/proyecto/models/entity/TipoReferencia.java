package com.prueba.commons.proyecto.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tipo_referencias")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TipoReferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
