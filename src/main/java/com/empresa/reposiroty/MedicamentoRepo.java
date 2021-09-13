package com.empresa.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Medicamento;

public interface MedicamentoRepo extends JpaRepository<Medicamento, Integer> {
	public List<Medicamento> findByNombreContaining(String nombre);
	public List<Medicamento> findByStock(int stock);
}
