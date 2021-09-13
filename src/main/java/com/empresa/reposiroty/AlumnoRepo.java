package com.empresa.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Alumno;

public interface AlumnoRepo extends JpaRepository<Alumno, Integer>{
	
	public List<Alumno> findByDni(String dni);
}
