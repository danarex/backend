
package com.portfolio.dana.Controller;

import com.portfolio.dana.Dto.dtoProyectos;
import com.portfolio.dana.Entity.Proyectos;
import com.portfolio.dana.Service.ImpProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyectos {
    @Autowired
    ImpProyectosService impProyectosService;
    
    @GetMapping ("/traer")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = impProyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")Long id){
        if(!impProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = impProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impProyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyectos eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impProyectosService.existsByNombreE(dtoproyectos.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = new Proyectos(
                dtoproyectos.getNombreE(), dtoproyectos.getDescripcionE(),dtoproyectos.getFechaE(),dtoproyectos.getLinkE(),dtoproyectos.getImgE()
            );
        impProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyectos creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/proyectos/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoProyectos dtoproyectos){
        if(!impProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(impProyectosService.existsByNombreE(dtoproyectos.getNombreE()) && impProyectosService.getByNombreE(dtoproyectos.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = impProyectosService.getOne(id).get();
        
       
       
         proyectos.setNombreE (dtoproyectos.getNombreE());
          proyectos.setDescripcionE(dtoproyectos.getDescripcionE());
        proyectos.setFechaE(dtoproyectos.getFechaE());
        proyectos.setImgE(dtoproyectos.getImgE());
        proyectos.setLinkE(dtoproyectos.getLinkE());
        
        impProyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyectos actualizada"), HttpStatus.OK);
    }
}



