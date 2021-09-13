package com.empresa.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Deporte;

public interface DeporteRepo extends JpaRepository<Deporte, Integer>{

}
