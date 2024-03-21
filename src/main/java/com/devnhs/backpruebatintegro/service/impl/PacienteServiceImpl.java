package com.devnhs.backpruebatintegro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.devnhs.backpruebatintegro.repository.DocumentoRepository;
import com.devnhs.backpruebatintegro.repository.PacienteAcompananteRepository;
import com.devnhs.backpruebatintegro.repository.PacienteRepository;
import com.devnhs.backpruebatintegro.repository.ParentescoRepository;
import com.devnhs.backpruebatintegro.repository.SexoRepository;
import com.devnhs.backpruebatintegro.repository.UbigeoRepository;
import com.devnhs.backpruebatintegro.service.PacienteService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Autowired
    private SexoRepository sexoRepository;

    @Autowired
    private ParentescoRepository parentescoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteAcompananteRepository pacienteAcompananteRepository;

    @Override
    public List<PacienteDTO> getAllPaciente() {

        Query query = entityManager.createNativeQuery(
                "SELECT * FROM \"Admision\".fn_obtener_datos_pacientes()",
                PacienteDTO.class);
        // query.setParameter(1, "pedro");

        @SuppressWarnings("unchecked")
        List<PacienteDTO> pacientes = query.getResultList();

        return pacientes;
    }

    @Override
    public List<Documento> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public List<PacienteDTO> searchPaciente(int criterio, int tipo_doc, String no_doc, String ape_pat_mat,
            String nombres) {

        Query query = entityManager.createNativeQuery(
                "SELECT * FROM \"Admision\".fn_buscar_paciente(?,?,?,?,?)",
                PacienteDTO.class);

        query.setParameter(1, criterio);
        query.setParameter(2, tipo_doc);
        query.setParameter(3, no_doc);
        query.setParameter(4, ape_pat_mat);
        query.setParameter(5, nombres);

        @SuppressWarnings("unchecked")
        List<PacienteDTO> pacientes = query.getResultList();

        return pacientes;
    }

    @Override
    public List<Sexo> getAlllSexo() {
        return sexoRepository.findAll();
    }

    @Override
    public List<Ubigeo> getAllUbigeo() {
        return ubigeoRepository.findAll();
    }

    @Override
    public List<DepartamentDTO> getAllDepa() {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM \"Admision\".fn_get_departamentos()",
                DepartamentDTO.class);

        @SuppressWarnings("unchecked")
        List<DepartamentDTO> depas = query.getResultList();

        return depas;
    }

    @Override
    public List<ProvinciaDTO> getAllProv(String depa) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM \"Admision\".fn_get_provincias(?)",
                ProvinciaDTO.class);
        query.setParameter(1, depa);

        @SuppressWarnings("unchecked")
        List<ProvinciaDTO> prov = query.getResultList();

        return prov;
    }

    @Override
    public List<DistritoDTO> getAllDist(String depa, String prov) {
        Query query = entityManager.createNativeQuery(
                "SELECT * FROM \"Admision\".fn_get_distritos(?,?)",
                DistritoDTO.class);
        query.setParameter(1, depa);
        query.setParameter(2, prov);

        @SuppressWarnings("unchecked")
        List<DistritoDTO> dist = query.getResultList();

        return dist;
    }

    @Override
    public List<Parentesco> getAllParent() {
        return parentescoRepository.findAll();
    }

    @Override
    public Paciente savePaciente(Paciente objpaciente) {
        return pacienteRepository.save(objpaciente);
    }

    @Override
    @Transactional
    public PacienteAcompanante savePacienteAcompanante(PacienteAcompanante objAcompanante, String no_docide_paciente) {
        Query query = entityManager.createNativeQuery(
                "SELECT p.id_paciente FROM \"Admision\".tb_paciente p WHERE p.no_docide = :param");
        query.setParameter("param", no_docide_paciente);

        List<?> list = query.getResultList();
        if (!list.isEmpty()) {
            Object id_paciente = list.get(0);
            if (id_paciente instanceof Integer) {
                int id = (int) id_paciente;
                objAcompanante.setId_paciente(id);
                return pacienteAcompananteRepository.save(objAcompanante);
            } else {
                throw new IllegalArgumentException("ID de paciente no válido.");
            }
        } else {
            throw new IllegalArgumentException(
                    "No se encontró ningún paciente con el número de documento proporcionado.");
        }
    }

    @Override
    @Transactional
    public List<PacienteDTO> deletePaciente(Integer id_paciente) {

        try {
            pacienteRepository.deleteById(id_paciente);
            Query query = entityManager.createNativeQuery(
                    "DELETE FROM \"Admision\".tb_paciente_acompanante p WHERE p.id_paciente = :param");
            query.setParameter("param", id_paciente);

            int rowsAffected = query.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("\n Se eliminaron " + rowsAffected + " registros. \n");
                return getAllPaciente();

            } else {
                System.out.println("\n No se elimnaron registros, el paciente no tenia acompañanate. \n");
                return getAllPaciente();
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("No se pudo eliminar el paciente.");
        }

    }

}
