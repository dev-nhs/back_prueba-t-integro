package com.devnhs.backpruebatintegro.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_paciente_acompanante")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacienteAcompanante implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_paciente_acompanante")
    private Integer id_paciente_acompanante;

    @Column(name = "id_paciente")
    private int id_paciente;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_tipo_docide", referencedColumnName = "id_tipo_documento_identidad")
    private Documento documento;

    @Column(name = "no_docide")
    private String no_docide;

    @Column(name = "no_apepat")
    private String no_apepat;

    @Column(name = "no_apemat")
    private String no_apemat;

    @Column(name = "no_nombres")
    private String no_nombres;

    @Column(name = "fe_nacimiento")
    private Date fe_nacimiento;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_parentesco", referencedColumnName = "id_parentesco")
    private Parentesco parentesco;

    @Column(name = "nu_telefo_contacto")
    private String nu_telefo_contacto;

    @Column(name = "no_direccion")
    private String no_direccion;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "co_ubigeo", referencedColumnName = "codigo_ubigeo")
    private Ubigeo ubigeo;
}
