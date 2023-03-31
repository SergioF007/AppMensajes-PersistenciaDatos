/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perisistencia.mensajes_p2;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class MensajesDAO {
    
    //Van los metodos que me van a permitir la conexion con la base de datos
    // esta capa es la que ejecuta la instrucciones SQL o sus Querys
    public static void crecarMensajeDB(Mensajes mensaje) {
        
        Conneciton db_connet = new Conneciton();
        
        try(Connection conexion = db_connet.get_connection()) {
            
            PreparedStatement ps = null; 
            try {
                /*
                String query1 = "USE mensajes_app;";
                ps = conexion.prepareStatement(query1);
                ps.executeUpdate();  */
                // Crearemos la Consulta para insertar Datos
                String query2 = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?);"; 
                ps=conexion.prepareStatement(query2);
                // Preparamps el primer parametro
                ps.setString(1, mensaje.getMensaje());
                // Preparamos el segundo parametros
                ps.setString(2, mensaje.getAutor_mensaje());
                
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
    public static void leerMensajesDB(int opcion) {
        
        Conneciton db_connet = new Conneciton(); 
        PreparedStatement ps = null;  // Preapararacion del la varaible que va a ejecutar el Query
        ResultSet rs = null; // Para listar los resultados
        
        switch (opcion) {
            case 1:
                try(Connection conexion = db_connet.get_connection()) {
            
                    String query = "SELECT * FROM mensajes;"; 
                    ps = conexion.prepareStatement(query);  //  ejecuto la el query 
                    rs = ps.executeQuery();  // me lista el resultado del query 
                    System.out.println(":: Lista De Mensajes  \n");

                    while(rs.next()) {                

                        System.out.println("ID: " + rs.getInt("id_mensaje"));
                        System.out.println("Mensaje: " + rs.getString("mensaje"));
                        System.out.println("Ator: " + rs.getString("autor_mensaje"));
                        System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                        System.out.println("-----------------------------------------------");   
                    }        
                } catch (SQLException e) {
                    System.out.println(e);
                }
                
                break;
            case 2:
                
                try(Connection conexion = db_connet.get_connection()) {
                    
                    Scanner sc = new Scanner(System.in); 
                    System.out.println("Ingrese el nombre de autor ");
                    String nombre = sc.nextLine(); 
                    
                    String query = "SELECT mensaje, fecha_mensaje FROM mensajes WHERE  LOWER(autor_mensaje) = LOWER(?)";
                    ps = conexion.prepareStatement(query); 
                    ps.setString(1, nombre);
                    rs = ps.executeQuery();
                    System.out.println("Mensajes de: " + nombre);
                    while (rs.next()) {
                        
                        System.out.println("Mensaje: " + rs.getString("mensaje"));
                        System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                        
                    } 
                
                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            case 3:
                
                try(Connection conexion = db_connet.get_connection()) {
     
                    String query = "SELECT * FROM mensajes ORDER BY fecha_mensaje DESC LIMIT 1;";
                    ps = conexion.prepareStatement(query);
                    rs = ps.executeQuery();
                    System.out.println("El ultimo mensaje guardado es: ");
                    
                    if (rs.next()) {
                        
                        System.out.println("Autor: " + rs.getString("autor_mensaje"));
                        System.out.println("Mensaje: " + rs.getString("mensaje"));
                        System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                        
                    }

                } catch (SQLException e) {
                    System.out.println(e);
                }
                break;
            default:
                break;
        }
        
        
    
    }
    public static void actualizarMensajesDB(Mensajes mensaje) {
        
        Conneciton db_connet = new Conneciton(); 
        
        PreparedStatement ps = null; 
        
        try(Connection conexion = db_connet.get_connection()) {
            
            
            
            try {            
                
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?;"; 
                
                ps = conexion.prepareStatement(query); 
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensajes());
                ps.executeUpdate(); 
                System.out.println("Mensaje actualizado correctamente");
                
            } catch (SQLException ex) {
                System.out.println(ex);
            } 

        } catch (SQLException e) {
            System.out.println(e); 
        }
        
    }
    public static void elimnarMensajes(int id) {
        
        Conneciton db_connet = new Conneciton(); 
       
        try(Connection conexion = db_connet.get_connection()) {
            
            PreparedStatement ps = null;
            
            String query="DELETE FROM mensajes WHERE id_mensaje = ?"; 
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id); 
            ps.execute(); 
            System.out.println("El mensajade con el id_mensaje = " + id + " Fue eliminado con Exitio");
        } catch (SQLException e) {
            System.out.println(e);
        }  
    }
    
}
