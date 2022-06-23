package com.ayudaperu.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayudaperu.app.models.Enviodonacion;



@Repository
public interface EnviodonacionRepository extends JpaRepository<Enviodonacion, Long>{

}
