
package com.portfolio.dana.Repository;

import com.portfolio.dana.Entity.Proyectos;
import com.portfolio.dana.Entity.Skills;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository <Skills, Long> {
  public Optional<Proyectos> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
    
}
