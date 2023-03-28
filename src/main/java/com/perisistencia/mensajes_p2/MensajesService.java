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
        registroMensajes.setAutor_mensaje(nombre);
        registroMensajes.setMensaje(mensaje);
        
        // Despues de creado el objeto, lo enviamos a la capa DAO
        MensajesDAO.crecarMensajeDB(registroMensajes);
        
    }
    
    public static void listarMensajes() {
        
    }
    
    public static void borrarMensajes() {
        
    }
    
    public static void editarMensaje() {
        
    }    
}
