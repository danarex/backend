
package com.portfolio.dana.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String porcentajeE;
 
 public dtoSkills() {
    }

    public dtoSkills(String nombreE, String porcentajeE) {
        this.nombreE = nombreE;
        this.porcentajeE = porcentajeE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getPorcentajeE() {
        return porcentajeE;
    }

    public void setPorcentajeE(String porcentajeE) {
        this.porcentajeE = porcentajeE;
    }
 
    
    
}


 