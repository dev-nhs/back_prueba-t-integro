package com.devnhs.backpruebatintegro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
import com.devnhs.backpruebatintegro.service.PacienteService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/paciente")
@RequiredArgsConstructor
@EnableWebMvc
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping()
    private ResponseEntity<List<PacienteDTO>> searchPaciente(@RequestParam(required = true) int criterio,
            @RequestParam(required = false) int tipo_doc,
            @RequestParam(required = false) String no_doc, @RequestParam(required = false) String ape_pat_mat,
            @RequestParam(required = false) String nombres) {

        return ResponseEntity.ok(pacienteService.searchPaciente(criterio, tipo_doc, no_doc, ape_pat_mat, nombres));
    }

    @GetMapping("/all")
    private ResponseEntity<List<PacienteDTO>> getAllPaciente() {
        return ResponseEntity.ok(pacienteService.getAllPaciente());
    }

    @GetMapping("/sexo/all")
    private ResponseEntity<List<Sexo>> getAlllSexo() {
        return ResponseEntity.ok(pacienteService.getAlllSexo());
    }

    @GetMapping("/ubigeo/all")
    private ResponseEntity<List<Ubigeo>> getAllUbigeo() {
        return ResponseEntity.ok(pacienteService.getAllUbigeo());
    }

    @GetMapping("/documento/all")
    public ResponseEntity<List<Documento>> getAlllDocumentos(){
        return ResponseEntity.ok(pacienteService.getAllDocumentos());
    }

    @GetMapping("/departamento/all")
    private ResponseEntity<List<DepartamentDTO>> getAllDepa() {
        return ResponseEntity.ok(pacienteService.getAllDepa());
    }

    @GetMapping("/provincia/all")
    private ResponseEntity<List<ProvinciaDTO>> getAllProv(@RequestParam(required = true) String depa) {
        return ResponseEntity.ok(pacienteService.getAllProv(depa));
    }

    @GetMapping("/distrito/all")
    private ResponseEntity<List<DistritoDTO>> getAllDist(@RequestParam(required = true) String depa,
            @RequestParam(required = false) String prov) {
        return ResponseEntity.ok(pacienteService.getAllDist(depa, prov));
    }

    @GetMapping("/parentesco/all")
    private ResponseEntity<List<Parentesco>> getAllParent() {
        return ResponseEntity.ok(pacienteService.getAllParent());
    }

    @PostMapping("/savepaciente")
    private ResponseEntity<Paciente> savePaciente(@RequestBody  Paciente paciente){
        
        return ResponseEntity.ok(pacienteService.savePaciente(paciente));
    }

    @PostMapping("/saveacompanante")
    private ResponseEntity<PacienteAcompanante> savePacienteAcompanante(@RequestBody PacienteAcompanante PacienteAcomapanate, @RequestParam(required = true) String no_docide_paciente){
        return ResponseEntity.ok(pacienteService.savePacienteAcompanante(PacienteAcomapanate, no_docide_paciente));
    }

    @DeleteMapping("/deletepaciente")
    private ResponseEntity<List<PacienteDTO>> deletePaciente(@RequestParam(required = true) Integer id_paciente){
        return ResponseEntity.ok(pacienteService.deletePaciente(id_paciente));
    }
}
