package com.proyectalpha.BackEndProyectAlpha.repositories;

import com.proyectalpha.BackEndProyectAlpha.models.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
}
