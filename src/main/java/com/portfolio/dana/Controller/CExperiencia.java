package com.portfolio.dana.Controller;

import com.portfolio.dana.Dto.dtoExperiencia;
import com.portfolio.dana.Entity.Experiencia;
import com.portfolio.dana.Service.ImpExperienciaService;
import com.portfolio.dana.security.controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    ImpExperienciaService impExperienciaService;
    
    @GetMapping ("/traer")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id")Long id){
        if(!impExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impExperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia){
        if(StringUtils.isBlank(dtoexperiencia.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impExperienciaService.existsByNombreE(dtoexperiencia.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = new Experiencia(
                dtoexperiencia.getNombreE(), dtoexperiencia.getPuestoE(),dtoexperiencia.getInicioE(),dtoexperiencia.getFinE(),dtoexperiencia.getImgE()
            );
        impExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoExperiencia dtoexperiencia){
        if(!impExperienciaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(impExperienciaService.existsByNombreE(dtoexperiencia.getNombreE()) && impExperienciaService.getByNombreE(dtoexperiencia.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoexperiencia.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = impExperienciaService.getOne(id).get();
        
       
       
         experiencia.setNombreE (dtoexperiencia.getNombreE());
          experiencia.setPuestoE(dtoexperiencia.getPuestoE());
        experiencia.setInicioE(dtoexperiencia.getInicioE());
        experiencia.setImgE(dtoexperiencia.getImgE());
        experiencia.setFinE(dtoexperiencia.getFinE());
        
        impExperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
}

