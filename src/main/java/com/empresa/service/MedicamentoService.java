package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Medicamento;

public interface MedicamentoService {
	public abstract List<Medicamento> listaMedicamento();
	public abstract Medicamento insertaMedicamento(Medicamento obj);
	public abstract Optional<Medicamento> obtenerPorId(int idMedicamento);
	public abstract List<Medicamento> filtroNombre(String nombre);
	public abstract List<Medicamento> buscaPorStock(int stock);
}
