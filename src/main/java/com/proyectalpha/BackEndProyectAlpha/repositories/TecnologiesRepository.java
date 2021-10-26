package com.proyectalpha.BackEndProyectAlpha.repositories;

import com.proyectalpha.BackEndProyectAlpha.models.Technologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiesRepository extends JpaRepository<Technologies, Long> {
}
