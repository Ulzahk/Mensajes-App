
package com.mycompany.mensajes_app;

/**
 *
 * @author USER
 */
public class Mensajes {
    
    //Atributos
    private int id_mensaje;
    private String mensaje;
    private String fecha;
    //Atributos Foraneos
    private int id_usuario;
    private String nombre_completo;
    
    //Constructores
    //Constructor General
    public Mensajes() {
    }
    
    //Constructor Borrar Mensaje por su ID
    public Mensajes(int id_mensaje, int id_usuario) {
        this.id_mensaje = id_mensaje;
        this.id_usuario = id_usuario;
    }
    
    //Constructor Crear Mensaje
    public Mensajes(String mensaje, int id_usuario) {
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
    }
    
    
    //Constructor Listar Mensajes
    public Mensajes(int id_mensaje, String mensaje, String fecha, String nombre_completo) {
        this.id_mensaje = id_mensaje;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.nombre_completo = nombre_completo;
    }
    
    //Getters y Setters
    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
    
    
    
    
    
    
 
}
