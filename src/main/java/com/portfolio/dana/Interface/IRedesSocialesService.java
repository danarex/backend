package com.portfolio.dana.Interface;

import com.portfolio.dana.Entity.RedesSociales;
import java.util.List;




public interface IRedesSocialesService {
    //traer lista de redessocialess

 
    public List <RedesSociales> getRedesSociales();
    
    //Guardar
    public void saveRedesSociales(RedesSociales redessociales);
    
    //Eliminar
    public void deleteRedesSociales (Long id);
    
    //Buscar
    public RedesSociales findRedesSociales (Long id);
}
