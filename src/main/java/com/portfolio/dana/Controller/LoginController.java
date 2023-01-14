
package com.portfolio.dana.Controller;

import com.portfolio.dana.Entity.Login;
import com.portfolio.dana.Interface.ILoginService;
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
public class LoginController {
    @Autowired ILoginService  iloginService;
    
    @GetMapping ("/login/traer")
    public List<Login> getLogin(){
        return iloginService.getLogin();
    }
    
    @PostMapping("/login/crear")
    public String createLogin(@RequestBody Login login){
        iloginService.saveLogin(login);
        return"La login fue creada correctamente";
    }
    
  
    @DeleteMapping("/login/borrar/{id}")
    public String deleteLogin(@PathVariable Long id){
        iloginService.deleteLogin(id);
     return "La Login fue eliminada correctamente";
    
    }
    
    @PutMapping ("/login/editar/{id}")
    public Login editLogin(@PathVariable Long id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("email") String nuevoEmail
                            
    ){
        
    Login login = iloginService.findLogin(id);
    
    login.setNombre(nuevoNombre);
    login.setEmail(nuevoEmail);

   
    
    iloginService.saveLogin(login);
    return login;
    }
    
    @GetMapping("/login/traer/perfil")
    public Login findLogin(){
        return iloginService.findLogin((long)1);
    }
}
