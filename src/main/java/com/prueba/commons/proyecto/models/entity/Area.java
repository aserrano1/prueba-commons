package com.prueba.commons.proyecto.models.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "areas")
public class Area implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "es requerido")
    @Column(unique = true, nullable = false)
    @Size(max = 20, message = "La cantidad maxima es 20 caracteres")
    private String codigo;

    @NotNull(message = "es requerido")
    @Column(unique = true, nullable = false)
    @Size(max = 80, message = "La cantidad maxima es 80 caracteres")
    private String descripcion;

    @Column(nullable = false)
    private Boolean estado;

    @Column(name = "prefijo_contable")
    private String prefijoContable;

    @Column(name = "dias_vacaciones")
    private Long diasVacaciones;

    @Column(name = "cuenta_nomina_por_pagar")
    private String cuentaNominaPorPagar;


    private static final long serialversionUID = 1L;


}
