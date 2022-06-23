package com.ayudaperu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayudaperu.app.models.Donacion;

@Repository
public interface DonacionRepository extends JpaRepository<Donacion, Long>{

}
