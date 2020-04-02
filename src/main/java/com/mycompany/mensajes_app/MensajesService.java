
package com.mycompany.mensajes_app;

import java.util.Scanner;

public class MensajesService {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void crearMensaje(Usuarios usuario){
        
        System.out.println("Escribe tu mensaje");
        String mensajeTexto = sc.nextLine();
        Mensajes mensaje = new Mensajes(mensajeTexto, usuario.getIdUsuario());
        MensajesDAO.crearMensajeBD(mensaje);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajeDB();
    }
    
    public static void borrarMensaje(Usuarios usuario){
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        Mensajes mensaje = new Mensajes(id_mensaje, usuario.getIdUsuario());
        MensajesDAO.borrarMensajeDB(mensaje);
    }
    
}
