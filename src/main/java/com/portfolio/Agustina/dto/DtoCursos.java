
package com.portfolio.Agustina.dto;

import javax.validation.constraints.NotBlank;

public class DtoCursos {
    @NotBlank
    private String nombreC;
    @NotBlank
    private String descripcionC;

    public DtoCursos() {
    }

    public DtoCursos(String nombreC, String descripcionC) {
        this.nombreC = nombreC;
        this.descripcionC = descripcionC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getDescripcionC() {
        return descripcionC;
    }

    public void setDescripcionC(String descripcionC) {
        this.descripcionC = descripcionC;
    }
    
    
}
