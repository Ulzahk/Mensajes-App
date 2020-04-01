package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do {            
            System.out.println("--------------------------");
            System.out.println(" Aplicación de Mensajes");
            System.out.println(" 1. Crear un Mensaje");
            System.out.println(" 2. Listar Mensajes");
            System.out.println(" 3. Editar Mensaje");
            System.out.println(" 4. Eliminar Mensaje");
            System.out.println(" 5. Salir"); 
            //Leemos la opción del usuario
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1: 
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                default:
                    System.out.println("Por favor seleccione una opción valida");
                    break;
            }
        } while (opcion != 5);
        Conexion conexion = new Conexion();
        
    }
}
