/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.DTOS;

import java.io.Serializable;

/**
 *
 * @author j_seb
 */
public class LibrosAutoresDTO implements Serializable {
    
    public String nombreAutor;//autor.nombre
    
    public String sexoAutor; //autor.sexo
    
    public String nacionalidadAutor; //autor.nacionalidad
    
    public Long codigoLibro; //libro.idlibro
    
    public String tituloLibro; //libro.titulo
    
    public String editorialLibro; //libro.editorial

    public LibrosAutoresDTO() {
    }

    public LibrosAutoresDTO(String nombreAutor, String sexoAutor, String nacionalidadAutor, Long codigoLibro, String tituloLibro, String editorialLibro) {
        this.nombreAutor = nombreAutor;
        this.sexoAutor = sexoAutor;
        this.nacionalidadAutor = nacionalidadAutor;
        this.codigoLibro = codigoLibro;
        this.tituloLibro = tituloLibro;
        this.editorialLibro = editorialLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getSexoAutor() {
        return sexoAutor;
    }

    public void setSexoAutor(String sexoAutor) {
        this.sexoAutor = sexoAutor;
    }

    public String getNacionalidadAutor() {
        return nacionalidadAutor;
    }

    public void setNacionalidadAutor(String nacionalidadAutor) {
        this.nacionalidadAutor = nacionalidadAutor;
    }

    public Long getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Long codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getEditorialLibro() {
        return editorialLibro;
    }

    public void setEditorialLibro(String editorialLibro) {
        this.editorialLibro = editorialLibro;
    }

    @Override
    public String toString() {
        return "LibrosAutoresDTO{" + "nombreAutor=" + nombreAutor + ", sexoAutor=" + sexoAutor + ", nacionalidadAutor=" + nacionalidadAutor + ", codigoLibro=" + codigoLibro + ", tituloLibro=" + tituloLibro + ", editorialLibro=" + editorialLibro + '}';
    }
    
    
    
}
