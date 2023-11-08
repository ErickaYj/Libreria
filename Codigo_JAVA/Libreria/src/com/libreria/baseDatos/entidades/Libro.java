/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.baseDatos.entidades;

import java.io.Serializable;
import java.util.Date;


public class Libro implements Serializable {
    
    private Long codigoLibro; //idlibro
    
    private String titulo; //titulo
    
    private Date fechaPublicacion; //fecha_publicacion
    
    private String editorial; //editorial
    
    private Long codigoAutor; //fk_autor_id

    public Libro() {
    }

    public Libro(Long codigoLibro, String titulo, Date fechaPublicacion, String editorial, Long codigoAutor) {
        this.codigoLibro = codigoLibro;
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.editorial = editorial;
        this.codigoAutor = codigoAutor;
    }

    public Long getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Long codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Long getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Long codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigoLibro=" + codigoLibro + ", titulo=" + titulo + ", fechaPublicacion=" + fechaPublicacion + ", editorial=" + editorial + ", codigoAutor=" + codigoAutor + '}';
    }
    
    
    
}
