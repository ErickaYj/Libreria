/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.baseDatos.serviciosCRUD;

import com.libreria.DTOS.LibrosAutoresDTO;
import com.libreria.baseDatos.ConexionBaseDatos;
import com.libreria.baseDatos.entidades.Libro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;


public class ServicioCRUDLibro {
    public static List<Libro> obtenerLibros() throws SQLException{
        List<Libro> respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
         try {
            //Abro conexion a la base de datosss
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM  libro ");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new ArrayList<>();
            while (rs.next()){
                Libro libroBDD = new Libro();
                libroBDD.setCodigoLibro(rs.getLong(1));
                libroBDD.setTitulo(rs.getString(2));
                libroBDD.setFechaPublicacion(rs.getDate(3));
                libroBDD.setEditorial(rs.getString(4));
                libroBDD.setCodigoAutor(rs.getLong(5));
                //Añado el objeto al listado de respuesta
                respuesta.add(libroBDD);
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
    
    public static Libro obtenerLibroPorID(Long codigoLibroABuscar) throws SQLException{
        Libro respuesta= null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        try {
            //Abro conexion a la base de datosss
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM  libro ");
            sb.append(" WHERE idlibro = " + codigoLibroABuscar);
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new Libro();
            while (rs.next()){
                Libro libroBDD= new Libro();
                libroBDD.setCodigoLibro(rs.getLong(1));
                libroBDD.setTitulo(rs.getString(2));
                libroBDD.setFechaPublicacion(rs.getDate(3));
                libroBDD.setEditorial(rs.getString(4));
                libroBDD.setCodigoAutor(rs.getLong(5));
                //Añado el objeto al listado de respuesta
                respuesta = libroBDD;
                
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
     * Metodo para insertar un nuevo Libro
     * @param libroInsertar
     * @return
     *     true= EXITO
     *     false= ERROR
     * @throws SQLException 
     */
    public static boolean libroInsertar (Libro libroInsertar) throws SQLException{
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
            sb.append("INSERT INTO libro (titulo , fecha_publicacion, editorial,fk_autor_id) "); //AQUI FALTABA fk_autor_id
            sb.append(" VALUES ( ");
            sb.append("'" + libroInsertar.getTitulo()+ "', ");
            sb.append("'" + new Date(libroInsertar.getFechaPublicacion().getTime())+"', ");
            sb.append("'" + libroInsertar.getEditorial()+ "', "); //AQUI FALTABA LA COMA
            sb.append("'"+libroInsertar.getCodigoAutor() + "' "); //AQUI FALTABA LA COMILLA PARA CERRAR EL TEXTO
            
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
    * @param libroActualizar registro a actualizar 
    * @return 
    *       true = EXITO
     *      false = ERROR
     * @throws SQLException 
    */
     public static boolean libroActualizar (Libro libroActualizar) throws SQLException{
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
            sb.append("UPDATE libro SET  ");
            sb.append(" titulo = '" + libroActualizar.getTitulo()+ "', " );
            sb.append(" fecha_publicacion = '" + new Date(libroActualizar.getFechaPublicacion().getTime())+ "', " );
            sb.append(" editorial  = '" + libroActualizar.getEditorial()+"', " );
            sb.append("fk_autor_id='"+libroActualizar.getCodigoAutor()+"' ");
            sb.append(" WHERE idlibro = " + libroActualizar.getCodigoLibro());
            
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
     * Metodo para eliminar un libro
     * @param libroEliminar autor eliminar
     * @return
     *   true = EXITO
     *   false = ERROR
     * @throws SQLException 
     */
     public static boolean libroEliminar (Libro libroEliminar ) throws SQLException{
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
            sb.append("DELETE FROM libro  ");
            sb.append(" WHERE idlibro = " + libroEliminar.getCodigoLibro());
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
            sb.append("SELECT MAX(idlibro) + 1  FROM libro ");
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