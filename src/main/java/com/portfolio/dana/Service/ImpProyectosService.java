package com.portfolio.dana.Service;

import com.portfolio.dana.Entity.Proyectos;
import com.portfolio.dana.Repository.IProyectosRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpProyectosService  {
    @Autowired  
    IProyectosRepository iproyectosRepository;

    
    public List<Proyectos> list() {
        return iproyectosRepository.findAll();
        
    }

 public Optional<Proyectos> getOne(Long id){
         return iproyectosRepository.findById(id);
     }
     
     public Optional<Proyectos> getByNombreE(String nombreE){
         return iproyectosRepository.findByNombreE(nombreE);
     }
     
     public void save(Proyectos educa){
         iproyectosRepository.save(educa);
     }
     
     public void delete(Long id){
         iproyectosRepository.deleteById(id);
     }
     
     public boolean existsById(Long id){
         return iproyectosRepository.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return iproyectosRepository.existsByNombreE(nombreE);
     }
}