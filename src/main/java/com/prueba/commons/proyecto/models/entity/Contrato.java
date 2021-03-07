package com.prueba.commons.proyecto.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contratos")
public class Contrato  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id=;

    private static final long serialversionUID = 1l;

    @Column(name = "codigo", unique = true)
    @NotNull(message = "no debe ser nulo")
    private String codigo;

    /*@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoDocumento", "ciudad", "genero",
            "estadoCivil", "formacion", "medioPago", "tipoCuenta", "financiera", "datosFamiliares"})
    private Empleado empleado;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "empresa", "jefeRRHH", "ciudad"})
    private Sede sede;*/

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Area area;

    /*@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cargo cargo;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FrecuenciaPago frecuenciaPago;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoDocumento"})
    private TipoContrato tipoContrato;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia modalidad;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia horasJornada;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia claseSalario;*/

    @Column(name = "valor_salario")
    private Double valorSalario;

    @NotNull(message = "No puede ser nulo")
    @Column(name = "fecha_contratacion", nullable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaContratacion;

    @Column(name = "fecha_terminacion")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaTerminacion;

    @Column(name = "fecha_vencimiento")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaVencimiento;


    /*@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoReferencia"})
    private DetalleTipoReferencia causaTerminacion;


    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ApiModelProperty(value = "Identificador del nivel de aseguramiento, es un valor numerico", required = true)
    private NivelRiesgo claseRiesgo;*/

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoDocumento"})
    private Fondo eps;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_afiliacion_eps")
    private LocalDate fechaAfiliacionEps;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoDocumento"})
    private Fondo fondoPension;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_afiliacion_pension")
    private LocalDate fechaAfiliacionPension;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoDocumento"})
    private Fondo fondoCesantias;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_afiliacion_cesantias")
    private LocalDate fechaAfiliacionCesantias;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tipoDocumento"})
    private Fondo fondoCajaCompensacion;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "fecha_afiliacion_caja")
    private LocalDate fechaAfiliacionCaja;

    /*
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "contrato", "diaContratoId"})
    private List<DiaContrato> dias;

    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "No puede ser nulo")
    @Column(name = "estado", nullable = false)
    private Estado estado;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "conceptos", "empleado"})
    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.MERGE,
                            CascadeType.REFRESH
                    })
    @JoinTable(name = "contratos_plantillas",
            joinColumns = {@JoinColumn(name = "contrato_id")},
            inverseJoinColumns = {@JoinColumn(name = "plantilla_id")})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Plantilla> plantillas;


    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler","tipoReferencia"})
    private DetalleTipoReferencia metodoRetencion;*/

    //@ApiModelProperty(value = "porcentaje de Gestion Concepto ")
    private Double porcentaje;

    /*@PrePersist
    public void setUp() {
        this.estado = Estado.ACTIVO;
    }*/

}
