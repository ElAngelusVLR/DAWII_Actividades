package com.empresa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.entity.Medicamento;
import com.empresa.service.MedicamentoService;

@RestController
@RequestMapping("/rest/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoService service;

	@GetMapping()
	@ResponseBody
	public ResponseEntity<List<Medicamento>> lista() {
		List<Medicamento> lista = service.listaMedicamento();
		return ResponseEntity.ok(lista);
	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Medicamento> inserta(@RequestBody Medicamento obj) {
		Medicamento objSalida = service.insertaMedicamento(obj);
		return ResponseEntity.ok(objSalida);
	}

	// FILTRAR POR DNI
	@GetMapping("/id/{paramId}")
	@ResponseBody
	public ResponseEntity<Medicamento> buscaPorId(@PathVariable("paramId") int idMedicamento) {
		Optional<Medicamento> optMedicamento = service.obtenerPorId(idMedicamento);

		if (optMedicamento.isPresent()) {
			return ResponseEntity.ok(optMedicamento.get());
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	// FILTRAR POR NOMBRE DE MEDICAMENTO
	@GetMapping("/nombre/{paramName}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> filtroNombre(@PathVariable("paramName") String nombre) {
		List<Medicamento> lista = service.filtroNombre(nombre);
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/stock/{paramStock}")
	@ResponseBody
	public ResponseEntity<List<Medicamento>> buscaPorStock(@PathVariable("paramStock") int stock) {
		List<Medicamento> lista = service.buscaPorStock(stock);
		return ResponseEntity.ok(lista);
	}
}
