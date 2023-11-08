/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.libreria.baseDatos;

import com.libreria.DTOS.LibrosAutoresDTO;
import com.libreria.baseDatos.entidades.Autor;
import com.libreria.baseDatos.serviciosCRUD.ServicioCRUDAutor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j_seb
 */
public class TestServicioCRUDAutor {
    
    public static void main(String[] args) {
        
        //buscarAutorPorID(new Long(3));
        
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
