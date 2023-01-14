
package com.portfolio.dana.Interface;

import com.portfolio.dana.Entity.Persona;
import java.util.List;




public interface IPersonaService {
    //traer lista de personas

 
    public List <Persona> getPersona();
    
    //Guardar
    public void savePersona(Persona persona);
    
    //Eliminar
    public void deletePersona (Long id);
    
    //Buscar
    public Persona findPersona (Long id);
}
