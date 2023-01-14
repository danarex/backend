package com.portfolio.dana.Interface;

import com.portfolio.dana.Entity.Login;
import java.util.List;




public interface ILoginService {
    //traer lista de logins

 
    public List <Login> getLogin();
    
    //Guardar
    public void saveLogin(Login login);
    
    //Eliminar
    public void deleteLogin (Long id);
    
    //Buscar
    public Login findLogin (Long id);
}
