/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.perisistencia.mensajes_p2;

/**
 *
 * @author USER
 */
public class Mensajes {
    
    // Modelo
    int id_mensajes; // deveria llamarse IdMensajes
    String mensaje; 
    String autor_mensaje;
    String fecha_mensaje;
    //creo dos constructores
    //1 constructor por defecto
    
    public Mensajes() {
    }
    
    // Segundo constructor

    public Mensajes(String mensaje, String autor_mensaje, String fecha_mensaje) {
        this.mensaje = mensaje;
        this.autor_mensaje = autor_mensaje;
        this.fecha_mensaje = fecha_mensaje;
    }
    
    public int getId_mensajes() {
        return id_mensajes;
    }

    public void setId_mensajes(int id_mensajes) {
        this.id_mensajes = id_mensajes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }
}
