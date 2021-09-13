package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Medicamento;
import com.empresa.reposiroty.MedicamentoRepo;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private MedicamentoRepo repository;
	
	@Override
	public List<Medicamento> listaMedicamento() {
		return repository.findAll();
	}

	@Override
	public Medicamento insertaMedicamento(Medicamento obj) {
		return repository.save(obj);
	}

	@Override
	public Optional<Medicamento> obtenerPorId(int idMedicamento) {
		return repository.findById(idMedicamento);
	}

	@Override
	public List<Medicamento> filtroNombre(String nombre) {
		return repository.findByNombreContaining(nombre);
	}

	@Override
	public List<Medicamento> buscaPorStock(int stock) {
		return repository.findByStock(stock);
	}

}
