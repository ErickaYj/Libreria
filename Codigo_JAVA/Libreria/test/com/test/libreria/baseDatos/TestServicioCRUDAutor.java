/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.libreria.baseDatos;

import com.libreria.DTOS.LibrosAutoresDTO;
import com.libreria.baseDatos.entidades.Autor;
import com.libreria.baseDatos.serviciosCRUD.ServicioCRUDAutor;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j_seb
 */
public class TestServicioCRUDAutor {
    
    public static void main(String[] args) {
        
        //buscarAutorPorID(new Long(3));
        //***** PRUEBA DE INSERTAR NUEVO AUTOR *****
        //autorInsertar(new Long(3), "Joaquin Gallejos", "22/09/1887","M","Ecuador");
        // ***** PRUEBA DE ACTUALIZAR AUTOR *****
        //actualizarAutor(new Long(2), "James Joyce", "07/01/1899","M", "Irlanda");
        //***** PRUEBA DE ELIMINAR AUTOR *****
        //autorEliminar(new Long(2));
        //***** GENERA UN NUEVO ID *****
        //obtenerSiguienteID();
        
        
        
        buscarLibrosConAutores();
        
    }
    
    public static void buscarAutorPorID(Long idABuscar){
        ServicioCRUDAutor servAutor = new ServicioCRUDAutor();
        Autor autorEncontrado = new Autor();
        try {
            autorEncontrado = servAutor.obtenerAutorPorID(idABuscar);
            if(autorEncontrado!=null && autorEncontrado.getCodigoAutor()!=null){
                System.out.println("REGISTRO DE AUTOR ENCONTRADO");
                System.out.println(autorEncontrado.toString());
            }else{
                System.out.println("NO SE ENCONTRO EL AUTOR CON ID: " + idABuscar);
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO buscarAutorPorID " + e);
        }
    }
    public static void autorInsertar (Long codigoAutor, String nombreAutor, Date fechaNacimiento, String sexo, String nacionalidad){
        ServicioCRUDAutor servAutor= new ServicioCRUDAutor();
        Autor InsertarAutor = new Autor(codigoAutor,nombreAutor,fechaNacimiento,sexo,nacionalidad);
        try {
            boolean respuestaInsercion = servAutor.autorInsertar(InsertarAutor);
            if(respuestaInsercion){
                System.out.println("EXITO AL INSERTAR NUEVO AUTOR:");
                System.out.println(InsertarAutor.toString());
            }else{
                System.err.println(" ERROR AL INSERTAR UN NUEVO AUTOR");
                System.err.println(InsertarAutor.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO autorInsertar " + e);
        }
    }
    public static void autorActualizar(Long codigoAutor, String nombreAutor, Date fechaNacimiento, String sexo, String nacionalidad){
        ServicioCRUDAutor servAutor= new ServicioCRUDAutor();
        Autor autorActualizar = new Autor(codigoAutor,nombreAutor,fechaNacimiento,sexo,nacionalidad);
         try {
            boolean respuestaActualizacion = servAutor.autorActualizar(autorActualizar);
            if(respuestaActualizacion){
                System.out.println("EXITO AL ACTUALIZAR EL AUTOR:");
                System.out.println(autorActualizar.toString());
            }else{
                System.err.println(" ERROR AL ACTUALIZAR EL AUTOR");
                System.err.println(autorActualizar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO actualizarAutor " + e);
        } 
    }
    public static void autorEliminar(Long codigoAutor){
        ServicioCRUDAutor servAutor= new ServicioCRUDAutor();
        Autor autorEliminar= new Autor();
        autorEliminar.setCodigoAutor(codigoAutor);
        try {
            boolean respuestaEliminacion = servAutor.autorEliminar(autorEliminar);
            if(respuestaEliminacion){
                System.out.println("EXITO AL ELIMINAR EL AUTOR:");
                System.out.println(autorEliminar.toString());
            }else{
                System.err.println(" ERROR AL ELIMINAR EL AUTOR");
                System.err.println(autorEliminar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO autorEliminarl " + e);
        }  
    } 
    public static void obtenerSiguienteID(){
        ServicioCRUDAutor servAutor= new ServicioCRUDAutor();
        try {
            Long nuevoID = servAutor.obtenerSiguienteID();
            System.out.println("Siguiente ID Tabla Autor es: " + nuevoID);
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO obtenerSiguienteID " + e);
        }
    
    }
   
    public static void buscarLibrosConAutores(){
        ServicioCRUDAutor servAutor = new ServicioCRUDAutor();
        List<LibrosAutoresDTO> listaLibroAutor = new ArrayList<>();
        try {
            listaLibroAutor = servAutor.buscarLibrosConAutores();
            if(listaLibroAutor!=null && !listaLibroAutor.isEmpty()){
                System.out.println("REGISROS ENCONTRADOS CON DTO");
                System.out.println(listaLibroAutor.toString());
            }else{
                System.out.println("NO SE ENCONTRARON LIBROS VS AUTORES");
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO buscarLibrosConAutores " + e);
        }
    }
   
    
}
