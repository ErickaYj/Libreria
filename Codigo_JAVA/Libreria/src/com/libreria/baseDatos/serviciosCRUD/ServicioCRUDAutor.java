/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.baseDatos.serviciosCRUD;

import com.libreria.DTOS.LibrosAutoresDTO;
import com.libreria.baseDatos.ConexionBaseDatos;
import com.libreria.baseDatos.entidades.Autor;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;


public class ServicioCRUDAutor {
    
    public static Autor obtenerAutorPorID(Long codigoAutorABuscar) throws SQLException{
        Autor respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
         try {
            //Abro conexion a la base de datosss
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM  autor ");
            sb.append(" WHERE autor_id = " + codigoAutorABuscar);
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new Autor();
            while (rs.next()){
                Autor autorBDD = new Autor();
                autorBDD.setCodigoAutor(rs.getLong(1));
                autorBDD.setNombreAutor(rs.getString(2));
                autorBDD.setFechaNacimiento(rs.getDate(3));
                autorBDD.setSexo(rs.getString(4));
                autorBDD.setNacionalidad(rs.getString(5));
                //Añado el objeto al listado de respuesta
                respuesta = autorBDD;
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        return respuesta;
    }
    
    
    // IMPLEMENTAR TODOS LOS SERVICIOS CRUD PARA LA TABLA AUTORS 
    
    
    /**
     * Metodo que contiene JOIN para consultar los libros con sus respectivos AUTORES
     * Este metodo usa DTOS (DTO =  Data Transfer Object)
     * @return
     * @throws SQLException 
     */
    public static List<LibrosAutoresDTO> buscarLibrosConAutores() throws SQLException{
        List<LibrosAutoresDTO> respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append(" SELECT ");
            sb.append(" autor.nombre, ");
            sb.append(" autor.sexo, ");
            sb.append(" autor.nacionalidad, ");
            sb.append(" libro.idlibro, ");
            sb.append(" libro.titulo, ");
            sb.append(" libro.editorial ");
            sb.append(" FROM autor JOIN libro ON autor.autor_id = libro.fk_autor_id ");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new ArrayList<>();
            while (rs.next()){
                
                LibrosAutoresDTO libroAutorBDD = new LibrosAutoresDTO();
                libroAutorBDD.setNombreAutor(rs.getString(1));
                libroAutorBDD.setSexoAutor(rs.getString(2));
                libroAutorBDD.setNacionalidadAutor(rs.getString(3));
                libroAutorBDD.setCodigoLibro(rs.getLong(4));
                libroAutorBDD.setTituloLibro(rs.getString(5));
                libroAutorBDD.setEditorialLibro(rs.getString(6));
                respuesta.add(libroAutorBDD);
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        return respuesta;
    }
    
}
