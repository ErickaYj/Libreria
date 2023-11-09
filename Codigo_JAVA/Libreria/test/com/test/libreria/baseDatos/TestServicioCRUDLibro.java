/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.libreria.baseDatos;

import com.libreria.baseDatos.entidades.Autor;
import com.libreria.baseDatos.entidades.Libro;
import com.libreria.baseDatos.serviciosCRUD.ServicioCRUDAutor;
import com.libreria.baseDatos.serviciosCRUD.ServicioCRUDLibro;
import java.util.Date;

/**
 *
 * @author j_seb
 */
public class TestServicioCRUDLibro {
     public static void main(String[] args) {
     //*****PRUEBA DE BUSQUEDA DE LIBRO POR ID*****
     //obtenerLibroPorID(new Long(2));
     //*****PRUEBA DE INSERTAR NUEVO LIBRO*****
     //libroInsertar(new Long(3),"Metamorfosis","1915/06/12","Alma",Long (3));
     //*****PRUEBA DE ACTUALIZAR LIBRO*****
     //libroActualizar(Long(2), "Cronica de una muerte","1981/05/19", "Random house", Long (1));
     //*****PRUEBA DE BUSQUEDA DE LIBRO POR ID*****
     //libroEliminar(new Long(1));
     //*****PRUEBA DE BUSQUEDA DE LIBRO POR ID*****
     //obtenerLibroPorID();
     
     
     }
    public static void obtenerLibroPorID(Long idABuscar){
    ServicioCRUDLibro servLibro = new ServicioCRUDLibro();
    Libro libroEncontrado = new Libro();
    try {
            libroEncontrado = servLibro.obtenerLibroPorID(idABuscar);
            if(libroEncontrado!=null && libroEncontrado.getCodigoAutor()!=null){
                System.out.println("REGISTRO DE AUTOR ENCONTRADO");
                System.out.println(libroEncontrado.toString());
            }else{
                System.out.println("NO SE ENCONTRO EL LIBRO CON ID: " + idABuscar);
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO obtenerLibroPorID " + e);
        }
    }
    public static void libroActualizar(Long codigoLibro, String titulo, Date fechaPublicacion, String editorial,Long codigoAutor){
        ServicioCRUDLibro servLibro= new ServicioCRUDLibro();
        Libro libroActualizar= new Libro(codigoLibro,titulo,fechaPublicacion, editorial, codigoAutor);
         try {
            boolean respuestaActualizacion = servLibro.libroActualizar(libroActualizar);
            if(respuestaActualizacion){
                System.out.println("EXITO AL ACTUALIZAR EL LIBRO:");
                System.out.println(libroActualizar.toString());
            }else{
                System.err.println(" ERROR AL ACTUALIZAR EL LIBRO");
                System.err.println(libroActualizar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO libroActualizar " + e);
        } 
    }
    public static void libroInsertar (Long codigoLibro, String titulo, Date fechaPublicacion, String editorial,Long codigoAutor){
    ServicioCRUDLibro servLibro= new ServicioCRUDLibro();
    Libro libroInsertar= new Libro (codigoLibro,titulo,fechaPublicacion, editorial, codigoAutor);
    try{
        boolean respuestaInsercion = servLibro.libroInsertar(libroInsertar);
            if(respuestaInsercion){
                System.out.println("EXITO AL INSERTAR NUEVO LIBRO:");
                System.out.println(libroInsertar.toString());
            }else{
                System.err.println(" ERROR AL INSERTAR UN NUEVO LIBRO");
                System.err.println(libroInsertar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO libroInsertar" + e);
        }
    }
    public static void libroEliminar(Long codigoLibro){
        ServicioCRUDLibro servLibro= new ServicioCRUDLibro();
        Libro libroEliminar= new Libro();
        libroEliminar.setCodigoLibro(codigoLibro);
        try {
            boolean respuestaEliminacion = servLibro.libroEliminar(libroEliminar);
            if(respuestaEliminacion){
                System.out.println("EXITO AL ELIMINAR EL LIBRO:");
                System.out.println(libroEliminar.toString());
            }else{
                System.err.println(" ERROR AL ELIMINAR EL LIBRO");
                System.err.println(libroEliminar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO libroEliminar " + e);
    }  
  
    }
    public static void obtenerSiguienteID(){
        ServicioCRUDLibro servLibro= new ServicioCRUDLibro();
        try {
            Long nuevoID = servLibro.obtenerSiguienteID();
            System.out.println("Siguiente ID Tabla Libro es: " + nuevoID);
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO obtenerSiguienteID " + e);
        }
    }
    }
        
    

