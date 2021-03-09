package com.prueba.commons.proyecto.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Builder
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "registro", precision = 10)
    private String registroEmpleado;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia tipoDocumento;

    @NotEmpty(message = "no debe estar vacio")
    @Column(name = "documento", nullable = false, unique = true)
    private String documentoEmpleado;

    @Column(name = "fecha_expedicion")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fechaExpedicion;

    @NotNull(message = "no debe estar vacio")
    @Column(name = "primer_nombre", nullable = false)
    private String primerNombre;

    @Column(name = "segundo_nombre")
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false)
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(nullable = false, name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "departamento"})
    private Ciudad ciudad;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","tipoReferencia"})
    private DetalleTipoReferencia genero;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","tipoReferencia"})
    private DetalleTipoReferencia estadoCivil;

    @Email(message = "no es una dirección de correo valida")
    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(nullable = false)
    private Boolean estado;

    private static final long serialVersionUID = 1120472356312844973L;
}
