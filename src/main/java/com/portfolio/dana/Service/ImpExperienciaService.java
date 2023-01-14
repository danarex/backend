
package com.portfolio.dana.Service;

import com.portfolio.dana.Entity.Experiencia;
import com.portfolio.dana.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpExperienciaService  {
    @Autowired  
    IExperienciaRepository iexperienciaRepository;

    
    public List<Experiencia> list() {
        return iexperienciaRepository.findAll();
        
    }

 public Optional<Experiencia> getOne(Long id){
         return iexperienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByNombreE(String nombreE){
         return iexperienciaRepository.findByNombreE(nombreE);
     }
     
     public void save(Experiencia educa){
         iexperienciaRepository.save(educa);
     }
     
     public void delete(Long id){
         iexperienciaRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return iexperienciaRepository.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return iexperienciaRepository.existsByNombreE(nombreE);
     }
}