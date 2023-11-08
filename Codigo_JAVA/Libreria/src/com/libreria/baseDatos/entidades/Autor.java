/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.baseDatos.entidades;

import java.io.Serializable;
import java.util.Date;


public class Autor implements Serializable {
    
    private Long codigoAutor; //autor_id
    
    private String nombreAutor; //nombre
    
    private Date fechaNacimiento; //fecha_nacimiento
    
    private String sexo; //sexo
    
    private String nacionalidad; //nacionalidad

    public Autor() {
    }

    public Autor(Long codigoAutor, String nombreAutor, Date fechaNacimiento, String sexo, String nacionalidad) {
        this.codigoAutor = codigoAutor;
        this.nombreAutor = nombreAutor;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }

    public Long getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Long codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" + "codigoAutor=" + codigoAutor + ", nombreAutor=" + nombreAutor + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
    
    
    
}
