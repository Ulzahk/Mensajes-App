package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    static Conexion dbConnect = new Conexion();

    public static void crearMensajeBD(Mensajes mensaje) {

        PreparedStatement ps = null;

        try ( Connection conexion = dbConnect.getConnection()) {

            String query = "INSERT INTO mensajes (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje Creado Exitosamente");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajeDB() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try ( Connection conexion = dbConnect.getConnection()) {

            String query = "SELECT * from mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor:" + rs.getString("autor_mensaje"));
                System.out.println("Fecha:" + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }

    public static void borrarMensajeDB(int id_mensaje) {

        PreparedStatement ps = null;

        try (Connection conexion = dbConnect.getConnection()) {

            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id_mensaje);
            ps.executeUpdate();
            System.out.println("El mensaje con ID " + id_mensaje + " ha sido borrado");

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("No se pudo borrar el mensaje");
        }

    }

    public static void actualizarMensajeBD(Mensajes mensaje) {
        
        PreparedStatement ps = null;
        
        try(Connection conexion = dbConnect.getConnection()) {
            
            String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getId_mensaje());
            ps.executeUpdate();
            System.out.println("El mensaje se actualizo correctamente");
            
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("No se pudo editar el mensaje");
        }
    }
}
