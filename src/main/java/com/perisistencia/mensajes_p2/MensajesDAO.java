/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perisistencia.mensajes_p2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class MensajesDAO {
    
    //Van los metodos que me van a permitir la conexion con la base de datos
    // esta capa es la que ejecuta la instrucciones SQL o sus Querys
    public static void crecarMensajeDB(Mensajes mensaje) {
        
        Conneciton db_connnet = new Conneciton();
        
        try(Connection conexion = db_connnet.get_connection()) {
            
            PreparedStatement ps = null; 
            try {
                // Crearemos la Consulta para insertar Datos
                String query="INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?)"; 
                ps=conexion.prepareStatement(query);
                // Preparamps el primer parametro
                ps.setString(1, mensaje.getMensaje());
                // Preparamos el segundo parametros
                ps.setString(2, mensaje.autor_mensaje);
                
                //Vamos a Ejcutar el comando que se encarga de enviar o darle la
                //instruccuon a la BD para que ejecute esta query. 
                ps.execute(); 
                System.out.println("El mensaje fue creado correctamente");    
            
            } catch (SQLException ex) {
                System.out.println(ex);
            } 
        } catch (SQLException e) {
            System.out.println(e);
        }    
    }
    public static void leerMensajesDB() {
        
    }
    public static void actualizarMensajesDB(Mensajes mensajes) {
        
    }
    public static void elimnarMensajes() {
        
    }
    
}
