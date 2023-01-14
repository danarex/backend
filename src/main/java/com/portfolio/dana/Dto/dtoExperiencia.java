
package com.portfolio.dana.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String puestoE;
    @NotBlank
    private String inicioE;
    @NotBlank
    private String finE;
    @NotBlank
    private String imgE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String puestoE, String inicioE, String finE, String imgE) {
        this.nombreE = nombreE;
        this.puestoE = puestoE;
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

    public String getPuestoE() {
        return puestoE;
    }

    public void setPuestoE(String tituloE) {
        this.puestoE = tituloE;
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