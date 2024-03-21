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
@Table(name = "tc_parentesco")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Parentesco implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_parentesco")
    private Integer id_parentesco;

    @Column(name = "no_parentesco")
    private String no_parentesco;

    @Column(name = "il_activo")
    private Boolean il_activo;

}
