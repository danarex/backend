
package com.portfolio.dana.Controller;

import com.portfolio.dana.Entity.RedesSociales;
import com.portfolio.dana.Interface.IRedesSocialesService;
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
public class RedesSocialesController {
    @Autowired IRedesSocialesService  iredessocialesService;
    
    @GetMapping ("/redessociales/traer")
    public List<RedesSociales> getRedesSociales(){
        return iredessocialesService.getRedesSociales();
    }
    
    @PostMapping("/redessociales/crear")
    public String createRedesSociales(@RequestBody RedesSociales redessociales){
        iredessocialesService.saveRedesSociales(redessociales);
        return"La redessociales fue creada correctamente";
    }
    
  
    @DeleteMapping("/redessociales/borrar/{id}")
    public String deleteRedesSociales(@PathVariable Long id){
        iredessocialesService.deleteRedesSociales(id);
     return "La RedesSociales fue eliminada correctamente";
    
    }
    
    @PutMapping ("/redessociales/editar/{id}")
    public RedesSociales editRedesSociales(@PathVariable Long id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("img") String nuevoImg
                            
    ){
        
    RedesSociales redessociales = iredessocialesService.findRedesSociales(id);
    
    redessociales.setNombre(nuevoNombre);
    redessociales.setImg(nuevoImg);

   
    
    iredessocialesService.saveRedesSociales(redessociales);
    return redessociales;
    }
    
    @GetMapping("/redessociales/traer/perfil")
    public RedesSociales findRedesSociales(){
        return iredessocialesService.findRedesSociales((long)1);
    }
}
