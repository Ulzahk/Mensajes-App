
package com.mycompany.mensajes_app;

import java.util.Scanner;

public class UsuariosService {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void crearUsuario(){
        System.out.println("Indica tu nombre completo");
        String nombreCompleto = sc.nextLine();
        System.out.println("Indica tu correo");
        String correo =  sc.nextLine();
        System.out.println("Indica tu clave");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);
        
        Usuarios registro = new Usuarios(0, correo, clave, nombreCompleto);
        UsuariosDAO.crearUsuarioDB(registro);
    }
    
    public static void listarUsuarios(){
        UsuariosDAO.leerUsuariosDB();
    }
    
    public static void editarUsuario(Usuarios usuario){
        System.out.println("Indica tu nombre completo");
        String nombreCompleto = sc.nextLine();
        System.out.println("Indica tu correo");
        String correo =  sc.nextLine();
        System.out.println("Indica tu clave");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);
        
        Usuarios registro = new Usuarios(usuario.getIdUsuario(), correo, clave, nombreCompleto);
        UsuariosDAO.editarUsuarioDB(registro);
        
    }
    
    public static String cifrarMD5(String clave){
        String md5Hex = clave;
        return md5Hex;
    }
    
    public static Usuarios iniciarSesion(){
        System.out.println("Indica tu correo");
        String correo = sc.nextLine();
        System.out.println("Indica tu clave");
        String clave = sc.nextLine();
        clave = cifrarMD5(clave);
        Usuarios login = new Usuarios(correo, clave);
        Usuarios resultado = UsuariosDAO.iniciarSesión(login);
        return resultado;
    }
    
    
    
    
}
