
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MensajesDAO {
    
    static Conexion dbConnect = new Conexion();
    
    public static void crearMensajeBD(Mensajes mensaje){
        
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
    
    public static void leerMensajeDB(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = dbConnect.getConnection()){
            String query = "SELECT * from mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje") );
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor:"+rs.getString("autor_mensaje"));
                System.out.println("Fecha:"+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }
    
    public static void borrarMensajeDB(int id_mensajes){
        
    }
    
    public static void actualizarMensajeBD(Mensajes mensaje){
        
    }
}
