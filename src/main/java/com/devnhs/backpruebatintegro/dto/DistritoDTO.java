package com.devnhs.backpruebatintegro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistritoDTO {
    
    private String descripcion_distrito;
    private String codigo_distrito;
}
