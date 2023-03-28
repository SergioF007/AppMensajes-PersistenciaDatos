/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.perisistencia.mensajes_p2;

import java.sql.Connection;

/**
 *
 * @author USER
 */
public class Mensajes_P2 {

    public static void main(String[] args) {
        
        Conneciton conexion = new Conneciton();
        
        try(Connection cnx = conexion.get_connection()) {
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
