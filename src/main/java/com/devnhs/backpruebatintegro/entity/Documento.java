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
@Table(name = "tc_tipo_documento_identidad")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Documento implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_tipo_documento_identidad")
    private Integer id_tipo_documento_identidad;

    @Column(name = "descripcion_tipo_documento_identidad")
    private String descripcion_tipo_documento_identidad;

    @Column(name = "codigo_ieds")
    private String codigo_ieds;

    //@Convert(converter = NumericBooleanConverter.class)
    @Column(name = "fl_estado")
    private Boolean fl_estado;

}
