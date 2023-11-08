/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.libreria.baseDatos;

import com.libreria.baseDatos.ConexionBaseDatos;



/**
 *
 * @author j_seb
 */
public class TestConexionBaseDatos {
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        try {
            conexion.obtenerConexion(null);
        } catch (Exception e) {
            System.err.println("Error en la conexión a la base de datos" + e);
                    
        }
    }
    
}
