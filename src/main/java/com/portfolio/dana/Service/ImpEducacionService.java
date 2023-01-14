
package com.portfolio.dana.Service;

import com.portfolio.dana.Entity.Educacion;
import com.portfolio.dana.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpEducacionService  {
    @Autowired  
    IEducacionRepository ieducacionRepository;

    
    public List<Educacion> list() {
        return ieducacionRepository.findAll();
        
    }

 public Optional<Educacion> getOne(Long id){
         return ieducacionRepository.findById(id);
     }
     
     public Optional<Educacion> getByNombreE(String nombreE){
         return ieducacionRepository.findByNombreE(nombreE);
     }
     
     public void save(Educacion educa){
         ieducacionRepository.save(educa);
     }
     
     public void delete(Long id){
         ieducacionRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return ieducacionRepository.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return ieducacionRepository.existsByNombreE(nombreE);
     }
}