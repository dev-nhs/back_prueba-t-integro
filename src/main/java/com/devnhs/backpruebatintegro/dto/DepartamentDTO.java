package com.devnhs.backpruebatintegro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentDTO {
    
    private String descripcion_departamento;
    private String codigo_departamento;
}
