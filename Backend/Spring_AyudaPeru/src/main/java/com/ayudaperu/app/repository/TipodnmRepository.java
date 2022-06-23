package com.ayudaperu.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayudaperu.app.models.Tipodnm;


@Repository
public interface TipodnmRepository extends JpaRepository<Tipodnm,Long> {

}
