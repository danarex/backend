

package com.portfolio.dana.Service;

import com.portfolio.dana.Entity.Proyectos;
import com.portfolio.dana.Entity.Skills;
import com.portfolio.dana.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpSkillsService  {
    @Autowired  
    ISkillsRepository iskillsRepository;

    
    public List<Skills> list() {
        return iskillsRepository.findAll();
        
    }

 public Optional<Skills> getOne(Long id){
         return iskillsRepository.findById(id);
     }
     
     public Optional<Proyectos> getByNombreE(String nombreE){
         return iskillsRepository.findByNombreE(nombreE);
     }
     
     public void save(Skills educa){
         iskillsRepository.save(educa);
     }
     
     public void delete(Long id){
         iskillsRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return iskillsRepository.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return iskillsRepository.existsByNombreE(nombreE);
     }
}