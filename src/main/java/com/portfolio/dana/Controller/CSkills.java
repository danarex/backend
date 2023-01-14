
package com.portfolio.dana.Controller;

import com.portfolio.dana.Dto.dtoSkills;
import com.portfolio.dana.Entity.Skills;
import com.portfolio.dana.Service.ImpSkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkills {
    @Autowired
    ImpSkillsService impSkillsService;
    
    @GetMapping ("/traer")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = impSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")Long id){
        if(!impSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = impSkillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        impSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Skills eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombreE())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(impSkillsService.existsByNombreE(dtoskills.getNombreE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = new Skills(
                dtoskills.getNombreE(), dtoskills.getPorcentajeE()
            );
        impSkillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skills creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/skills/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoSkills dtoskills){
        if(!impSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(impSkillsService.existsByNombreE(dtoskills.getNombreE()) && impSkillsService.getByNombreE(dtoskills.getNombreE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getNombreE())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = impSkillsService.getOne(id).get();
        
       
       
         skills.setNombreE (dtoskills.getNombreE());
          skills.setPorcentajeE(dtoskills.getPorcentajeE());
      

        impSkillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Skills actualizada"), HttpStatus.OK);
    }
}

