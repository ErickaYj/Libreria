/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.libreria.baseDatos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConexionBaseDatos implements Serializable{
    
    private Connection conn = null;
    
    public Connection obtenerConexion(String nombreDataSource) throws NamingException, SQLException, ClassNotFoundException {

        if (nombreDataSource != null) {
            Context contexto = new InitialContext();
            DataSource dt = (DataSource) contexto.lookup(nombreDataSource);
            conn = dt.getConnection();
        } else {
            obtenerConexion();
        }
        return conn;
    }
    
    private Connection obtenerConexion() throws NamingException, SQLException, ClassNotFoundException {
        if (conn == null) {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","libreria", "erika123"); // PRODUCCION
            System.out.println("CONEXION A BASE DE DATOS <<libreria>> EN MYSQL EXITOSA");
        }
        return conn;
    }

    public void cerrarConexion() throws SQLException {
        if (!conn.isClosed()) {
            try {
                conn.close();
            } catch (SQLException sqle) {
                System.out.println("Error al tratar de cerrar la conexion " + sqle.getMessage());
            }
        }
    }

    public void cerrarResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqle) {
                System.out.println("Error al cerrar ResultSet " + sqle.getMessage());
            }
        }
    }

    public void cerrarPreparedStatement(PreparedStatement stm) throws SQLException {
        if (stm != null) {
            try {
                    stm.close();
            } catch (SQLException sqle) {
                    System.out.println("Error al cerrar PreparedStatement " + sqle.getMessage());
            }
        }
    }

    public void cerrarConexiones(ResultSet rs, PreparedStatement stm) throws SQLException {
        cerrarResultSet(rs);
        cerrarPreparedStatement(stm);
        cerrarConexion();
    }  
    
}
