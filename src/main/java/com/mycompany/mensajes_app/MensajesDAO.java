
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class MensajesDAO {
    
    public static void crearMensajeBD(Mensajes mensaje){
        Conexion dbConnect = new Conexion();
        try(Connection conexion = dbConnect.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje Creado Exitosamente");
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void leerMensaje(){
        
    }
    
    public static void borrarMensaje(int id_mensajes){
        
    }
    
    public static void actualizarMensajeBD(Mensajes mensaje){
        
    }
}
