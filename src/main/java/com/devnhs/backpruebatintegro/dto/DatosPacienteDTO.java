package com.devnhs.backpruebatintegro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatosPacienteDTO {

    private String tipo_doc;
    private Integer num_doc;
    private String ape_nom;
    private String genero;
    private String fe_nac;
    private Integer edad;
    private String lug_nac;
    private String dir;
    private Integer ubigeo;

}
