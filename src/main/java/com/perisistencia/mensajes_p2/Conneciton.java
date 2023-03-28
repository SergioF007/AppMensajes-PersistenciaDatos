/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perisistencia.mensajes_p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Conneciton {
    
    public Connection get_connection() throws SQLException {
        
        Connection conection = null;
        
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            
            if(conection != null){
                System.out.println("Conexion Exitosa");
            }
        }catch(SQLDataException e){
            System.out.println(e);
        }
        
        return conection;
    }
    
}
