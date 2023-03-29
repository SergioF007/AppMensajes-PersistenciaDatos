/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perisistencia.mensajes_p2;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class MensajesService {
    // la intermedia entre el menu principal y la capa de acceso 
    // comienzo 
    
    // Esta capa es la encargada de preguntarnos los datos para enviarcelos
    // a la capa de mensajesDAO. 
    
    public static void creaMensaje() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu Mensaje");
        String mensaje = sc.nextLine(); 
        
        System.out.println("Autor: ");
        String nombre = sc.nextLine(); 
        
        Mensajes registroMensajes = new Mensajes();
        registroMensajes.setMensaje(mensaje);
        registroMensajes.setAutor_mensaje(nombre);
        
        
        // Despues de creado el objeto, lo enviamos a la capa DAO
        MensajesDAO.crecarMensajeDB(registroMensajes);
    }
    
    public static void listarMensajes() {
        
        Scanner sc = new Scanner(System.in); 
        int response = 0; 
        do {
            System.out.println("\n");    
            System.out.println("Seleccionae la Opcion Deseada: ");
            System.out.println("1. Ver Todos los Mensajes");
            System.out.println("2. Buscar los Mensajes por Autor");
            System.out.println("3. Ver el utlimo Mensaje");
            System.out.println("0. Salir ");
            response = sc.nextInt(); 
            MensajesDAO.leerMensajesDB(response);
        } while(response != 0);  
    }
    
    public static void borrarMensajes() {
        
    }
    
    public static void editarMensaje() {
        
    }    
}
