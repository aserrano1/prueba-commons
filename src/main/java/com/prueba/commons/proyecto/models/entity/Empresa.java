package com.prueba.commons.proyecto.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa implements Serializable {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia tipoDocumento;

    @NotEmpty(message = "no debe estar vacio")
    @Column(name = "numero_documento", nullable = false, unique = true)
    private String identificacion;

    private String div;

    @NotEmpty(message = "no debe estar vacio")
    @Column(name = "razon_social", nullable = false, unique = true)
    private String razonSocial;

    @Size(max = 50, message = "el tamaño máximo de caracteres es 50")
    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @NotNull(message = "El campo es requerido")
    @Size(max = 50, message = "el tamaño máximo de caracteres es 50")
    @Column(name = "nombre_contacto", nullable = false)
    private String nombreContacto;

    @NotNull(message = "El campo es requerido")
    @Email(message = "no es una dirección de correo valida")
    @Column(name = "correo_electronico", nullable = false)
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private Empleado representanteLegal;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia tipoPersona;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia naturalezaJuridica;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "departamento"})
    private Ciudad ciudad;

    @Column(nullable = false)
    private Boolean estado;

    private String imagenPerfil;

    @PrePersist
    public void estadoRegistro(){
        this.estado = true;
    }

    private static final long serialVersionUID = 2377695618483384128L;
}
