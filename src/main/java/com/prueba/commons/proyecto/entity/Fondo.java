package com.prueba.commons.proyecto.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "fondos")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fondo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
