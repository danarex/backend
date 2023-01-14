
package com.portfolio.dana.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String tituloE;
    @NotBlank
    private String inicioE;
    @NotBlank
    private String finE;
    @NotBlank
    private String imgE;
    

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String tituloE, String inicioE, String finE, String imgE) {
        this.nombreE = nombreE;
        this.tituloE = tituloE;
        this.inicioE = inicioE;
        this.finE = finE;
        this.imgE = imgE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }
    
    public String getInicioE() {
        return inicioE;
    }

    public void setInicioE(String inicioE) {
        this.inicioE = inicioE;
    }
    
    public String getFinE() {
        return finE;
    }

    public void setFinE(String finE) {
        this.finE = finE;
    }
    
    public String getImgE() {
        return imgE;
    }

    public void setImgE(String imgE) {
        this.imgE = imgE;
    }
    
    
}