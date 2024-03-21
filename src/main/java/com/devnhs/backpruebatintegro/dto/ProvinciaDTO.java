package com.devnhs.backpruebatintegro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaDTO {
    
    private String descripcion_provincia;
    private String codigo_provincia;
}
