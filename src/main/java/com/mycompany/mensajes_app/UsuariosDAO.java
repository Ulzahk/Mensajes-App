
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuariosDAO {
    
    static Conexion dbConnect = new Conexion();
    
    public static void crearUsuarioDB(Usuarios usuario){
        PreparedStatement ps = null;
        try(Connection conexion = dbConnect.getConnection()) {
            String query = "INSERT INTO usuarios(correo, clave, nombre_completo) VALUES (?, ?, ?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getClave());
            ps.setString(3, usuario.getNombreCompleto());
            ps.executeUpdate();
            System.out.println("\n Usuario creado con exito. Ahora puedes iniciar sesión.");
        } catch (SQLException e) {
            System.out.println("\n No se pudo crear el usuario \n ");
            System.out.println(e);
        }
    }
    
    public static void leerUsuariosDB(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = dbConnect.getConnection()){
            String query = "SELECT * FROM usuarios";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.print("\n[ID: "+ rs.getString("id_usuario")+ " | ");
                System.out.print("Correo: "+rs.getString("correo")+ " | ");
                System.out.print("Nombre: "+rs.getString("nombre_completo")+" ] ");
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("\n No se pudo listar los usuarios \n");
            System.out.println(e);
        }
    }
    
    public static void editarUsuarioDB(Usuarios usuario){
        PreparedStatement ps = null;
        try(Connection conexion = dbConnect.getConnection()) {
            String query = "UPDATE usuarios SET correo = ?, clave = ?, nombre_completo = ? WHERE id_usuario = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, usuario.getCorreo());
            ps.setString(2, usuario.getClave());
            ps.setString(3, usuario.getNombreCompleto());
            ps.setInt(4, usuario.getIdUsuario());
            ps.executeUpdate();
            System.out.println("\n Usuario actualizado");
        } catch (SQLException e) {
            System.out.println("\n No se pudo actualizar el usuario \n");
            System.out.println(e);
        }
    }
    
    public static Usuarios iniciarSesión(Usuarios usuario){
        
    }
}
