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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;


public class ServicioCRUDAutor {
    
    public static List<Autor> obtenerAutores() throws SQLException{
        List<Autor> respuesta = null;
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
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new ArrayList<>();
            while (rs.next()){
                Autor autorBDD = new Autor();
                autorBDD.setCodigoAutor(rs.getLong(1));
                autorBDD.setNombreAutor(rs.getString(2));
                autorBDD.setFechaNacimiento(rs.getDate(3));
                autorBDD.setSexo(rs.getString(4));
                autorBDD.setNacionalidad(rs.getString(5));
                //Añado el objeto al listado de respuesta
                respuesta.add(autorBDD);
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
    /**
     * Metodo para insertar un nuevo Autor
     * @param autorInsertar
     * @return
     *     true= EXITO
     *     false= ERROR
     * @throws SQLException 
     */
    public static boolean autorInsertar (Autor autorInsertar) throws SQLException{
     boolean respuesta = true;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO autor (nombre , fecha_nacimiento, sexo, nacionalidad) ");
            sb.append(" VALUES ( ");
            sb.append("'" + autorInsertar.getNombreAutor()+ "', ");
            sb.append("'" + new Date(autorInsertar.getFechaNacimiento().getTime()) + "', ");
            sb.append("'" + autorInsertar.getSexo()+ "', ");
            sb.append("'" + autorInsertar.getNacionalidad()+ "' ");
            
            sb.append(" ) ");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            pstCons.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            respuesta = false;
        } catch (NamingException e){
            e.printStackTrace();
            respuesta = false;
        } catch (SQLException e){
            e.printStackTrace();
            respuesta = false;
        } catch (Exception e){
            e.printStackTrace();
            respuesta = false;
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    /**
    * Metodo para actualizar un registro
    * @param autorActualizar registro a actualizar 
    * @return 
    *       true = EXITO
     *      false = ERROR
     * @throws SQLException 
    */
    public static boolean autorActualizar (Autor autorActualizar) throws SQLException{
        boolean respuesta = true;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE autor SET  ");
            sb.append(" nombre = '" + autorActualizar.getNombreAutor()+ "', " );
            sb.append(" fecha_nacimiento = '" + new Date(autorActualizar.getFechaNacimiento().getTime())+ "', " );
            sb.append(" sexo  = '" + autorActualizar.getSexo()+ "', ");
            sb.append(" nacionalidad  = '" + autorActualizar.getNacionalidad()+ "' ");
            sb.append(" where autor_id  = " + autorActualizar.getCodigoAutor());
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            int resultadoActualizacion = pstCons.executeUpdate();
            if(resultadoActualizacion ==0)
                respuesta = false;
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            respuesta = false;
        } catch (NamingException e){
            e.printStackTrace();
            respuesta = false;
        } catch (SQLException e){
            e.printStackTrace();
            respuesta = false;
        } catch (Exception e){
            e.printStackTrace();
            respuesta = false;
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    /**
     * Metodo para eliminar un autor
     * @param autorEliminar autor eliminar
     * @return
     *   true = EXITO
     *   false = ERROR
     * @throws SQLException 
     */
     public static boolean autorEliminar (Autor autorEliminar) throws SQLException{
        boolean respuesta = true;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM autor  ");
            sb.append(" WHERE autor_id  = " + autorEliminar.getCodigoAutor());
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            int resultadoActualizacion = pstCons.executeUpdate();
            if(resultadoActualizacion ==0)
                respuesta = false;
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            respuesta = false;
        } catch (NamingException e){
            e.printStackTrace();
            respuesta = false;
        } catch (SQLException e){
            e.printStackTrace();
            respuesta = false;
        } catch (Exception e){
            e.printStackTrace();
            respuesta = false;
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    /**
     * Metodo para obtener el siguiente ID de un nuevo registro
     * @return
     * @throws SQLException 
     */
    public static Long obtenerSiguienteID() throws SQLException{
        Long respuesta = new Long(-1);
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT MAX(autor_id) + 1  FROM autor ");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            while (rs.next()){
                respuesta = rs.getLong(1);
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
