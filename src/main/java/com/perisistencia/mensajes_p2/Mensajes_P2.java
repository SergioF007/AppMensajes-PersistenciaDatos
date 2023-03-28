/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.perisistencia.mensajes_p2;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Mensajes_P2 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int response = 0; 
        
        do {  
            System.out.println("---------------------------");
            System.out.println("1. Crear un Mensaje");
            System.out.println("2. Listar Menasje");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            
            response = sc.nextInt(); 
            
            switch (response) {
                case 1:
                    MensajesService.creaMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.editarMensaje();
                    break;
                case 4:
                    MensajesService.borrarMensajes();
                    break;                    
                default:
                    break;
            }
            
            
            
            
        } while (response != 5);
        
        Conneciton conexion = new Conneciton();
        
        /*
        try(Connection cnx = conexion.get_connection()) {
            
        } catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}
