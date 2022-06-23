package com.ayudaperu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayudaperu.app.models.Voluntario;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

}
