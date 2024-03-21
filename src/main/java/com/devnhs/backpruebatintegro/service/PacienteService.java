package com.devnhs.backpruebatintegro.service;

import java.util.List;

import com.devnhs.backpruebatintegro.dto.DepartamentDTO;
import com.devnhs.backpruebatintegro.dto.DistritoDTO;
import com.devnhs.backpruebatintegro.dto.PacienteDTO;
import com.devnhs.backpruebatintegro.dto.ProvinciaDTO;
import com.devnhs.backpruebatintegro.entity.Documento;
import com.devnhs.backpruebatintegro.entity.Paciente;
import com.devnhs.backpruebatintegro.entity.PacienteAcompanante;
import com.devnhs.backpruebatintegro.entity.Parentesco;
import com.devnhs.backpruebatintegro.entity.Sexo;
import com.devnhs.backpruebatintegro.entity.Ubigeo;

public interface PacienteService {

    public List<PacienteDTO> searchPaciente(int criterio, int tipo_doc, String no_doc, String ape_pat_mat, String nombres);

    public List<PacienteDTO> getAllPaciente();

    public List<Documento> getAllDocumentos();

    public List<Sexo> getAlllSexo();

    public List<Ubigeo> getAllUbigeo();

    public List<Parentesco> getAllParent();

    public List<DepartamentDTO> getAllDepa();

    public List<ProvinciaDTO> getAllProv(String depa);

    public List<DistritoDTO> getAllDist(String depa, String prov);

    public Paciente savePaciente(Paciente objpaciente );

    public PacienteAcompanante savePacienteAcompanante(PacienteAcompanante objpaciente, String no_docide_paciente);

    public List<PacienteDTO> deletePaciente(Integer id_paciente);

}
