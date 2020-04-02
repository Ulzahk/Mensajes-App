
package com.mycompany.mensajes_app;

import java.util.Scanner;

public class MensajesService {
    
        static Scanner sc = new Scanner(System.in);
    
    public static void crearMensaje(){
        
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeBD(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajeDB();
    }
    
    public static void borrarMensaje(){
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        
        MensajesDAO.borrarMensajeDB(id_mensaje);
    }
    
    public static void editarMensaje(){
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Indica el ID del mensaje a editar");
        int id_mensaje = sc.nextInt();
        
        Mensajes actualizacion = new Mensajes();
        actualizacion.setMensaje(mensaje);
        actualizacion.setId_mensaje(id_mensaje);
        MensajesDAO.actualizarMensajeBD(actualizacion);
    }
}
