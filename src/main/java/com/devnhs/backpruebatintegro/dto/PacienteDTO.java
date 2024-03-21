package com.devnhs.backpruebatintegro.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    
    private Integer id_paciente;
    private String no_apepat;
    private String no_apemat;
    private String no_nombres;
    private String codigo_ieds;
    private String no_docide;
    private boolean fl_estado;
    private Date fe_nacimiento;
}
