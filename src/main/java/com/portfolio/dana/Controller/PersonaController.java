
package com.portfolio.dana.Controller;

import com.portfolio.dana.Entity.Persona;
import com.portfolio.dana.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService  ipersonaService;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return"La persona fue creada correctamente";
    }
    
  
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
     return "La Persona fue eliminada correctamente";
    
    }
    
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("apellido") String nuevoApellido,
                            @RequestParam("email") String nuevoEmail,
                            @RequestParam("img") String nuevoImg,
                            @RequestParam("sobreMi") String nuevoSobreMi
    ){
        
    Persona persona = ipersonaService.findPersona(id);
    
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setEmail(nuevoEmail);
    persona.setImg(nuevoImg);
    persona.setSobreMi(nuevoSobreMi);
   
    
    ipersonaService.savePersona(persona);
    return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}
