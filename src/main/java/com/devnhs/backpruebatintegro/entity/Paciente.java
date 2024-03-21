package com.devnhs.backpruebatintegro.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "tb_paciente")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_paciente")
    private Integer id_paciente;

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

    @ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sexo", referencedColumnName = "id_sexo")
    private Sexo sexo;

    @Column(name = "fe_nacimiento")
    private Date fe_nacimiento;

    @Column(name = "no_lugar_nacimiento")
    private String no_lugar_nacimiento;

    @Column(name = "no_direccion")
    private String no_direccion;

    @ManyToOne //(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "co_ubigeo", nullable = false, unique = true, referencedColumnName = "codigo_ubigeo")
    private Ubigeo ubigeo;

}
