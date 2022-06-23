package com.ayudaperu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.ayudaperu.app.models.Tipodocumento;


@Repository
public interface TipodocumentoRepository extends JpaRepository<Tipodocumento, Long>{
}
