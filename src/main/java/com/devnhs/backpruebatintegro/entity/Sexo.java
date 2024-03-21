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
@Table(name = "tc_sexo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sexo implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id_sexo")
    private Integer id_sexo;

    @Column(name = "descripcion_sexo")
    private String descripcion_sexo;

    @Column(name = "fl_estado")
    private Boolean fl_estado;

}
