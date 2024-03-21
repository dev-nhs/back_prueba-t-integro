package com.devnhs.backpruebatintegro.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tc_ubigeo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ubigeo implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "codigo_ubigeo", length = 6, nullable = false, unique = true)
    private String codigo_ubigeo;

    @Column(name = "descripcion_departamento")
    private String descripcion_departamento;

    @Column(name = "descripcion_provincia")
    private String descripcion_provincia;

    @Column(name = "descripcion_distrito")
    private String descripcion_distrito;

    @Column(name = "fl_estado")
    private Boolean fl_estado;

    @Column(name = "codigo_departamento")
    private String codigo_departamento;

    @Column(name = "codigo_provincia")
    private String codigo_provincia;

    @Column(name = "codigo_distrito")
    private String codigo_distrito;
}
