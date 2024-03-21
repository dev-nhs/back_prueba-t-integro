package com.devnhs.backpruebatintegro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DatosPacienteAcompananteDTO {

    private String tipo_doc;
    private Integer num_doc;
    private String ape_nom;
    private String fe_nac;
    private String edad;
    private String parentesco;
    private String contacto;
    private String dir;
    private String ubigeo;

}
