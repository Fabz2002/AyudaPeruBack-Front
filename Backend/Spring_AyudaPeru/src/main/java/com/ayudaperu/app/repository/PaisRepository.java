package com.ayudaperu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayudaperu.app.models.Pais;


@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
