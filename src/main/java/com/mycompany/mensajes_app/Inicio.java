package com.mycompany.mensajes_app;

import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        //Primer Menú
        do {
            System.out.println("============================");
            System.out.println("\n Mini Red Social \n");
            System.out.println(" 1. Registrarse");
            System.out.println(" 2. Iniciar Sesión");
            System.out.println(" 3. Salir \n");
            //Leemos la opción del usuario
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    UsuariosService.crearUsuario();
                    break;
                case 2:
                    Usuarios resultado = UsuariosService.iniciarSesion();
                    if (resultado.getIdUsuario() > 0) {
                        menuSesion(resultado);
                    }
                    break;
                default:
                    System.out.println("Por favor seleccione una opción valida");
                    break;
            }
        } while (opcion != 3);
    }

    public static void menuSesion(Usuarios usuario) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        //Menú despues de iniciar sesión
        do {
            System.out.println("=======================================");
            System.out.println("\n Red Social, Hola " + usuario.getNombreCompleto() + " \n");
            System.out.println("1. Escribir Mensaje");
            System.out.println("2. Leer Mensajes");
            System.out.println("3. Eliminar Mensaje");
            System.out.println("4. Editar Perfil");
            System.out.println("5. Ver Usuarios");
            System.out.println("6. Cerrar Sesión");

            opcion = sc.nextInt();

            switch (opcion) {
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
                    UsuariosService.editarUsuario();
                    break;
                case 5:
                    UsuariosService.listarUsuarios();
                    break;
                default:
                    System.out.println("Por favor seleccione una opcion valida");
                    break;
            }
        } while (opcion != 6);
    }
}
