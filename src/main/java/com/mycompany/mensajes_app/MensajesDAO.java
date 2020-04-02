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

            String query = "INSERT INTO mensajes (id_usuario, mensaje, autor_mensaje) VALUES (?, ?, CURRENT_TIMESTAMP)";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, mensaje.getId_usuario());
            ps.setString(2, mensaje.getMensaje());
            ps.executeUpdate();
            System.out.println("\n Mensaje Creado Exitosamente \n");

        } catch (SQLException e) {
            System.out.println("\n No se pudo crear el mensaje \n");
            System.out.println(e);
        }
    }

    public static void leerMensajeDB() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try ( Connection conexion = dbConnect.getConnection()) {

            String query = "SELECT m.id_mensaje, m.mensaje, m.fecha, u.nombre_completo from mensajes m"
                    + "JOIN usuarios u ON m.id_usuario = u.id_usuario";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.print("\n[ID: " + rs.getInt("id_mensaje")+ " | ");
                System.out.print("Mensaje: " + rs.getString("mensaje") + " | ");
                System.out.print("Fecha:" + rs.getString("fecha") + " | ");
                System.out.print("Autor:" + rs.getString("nombre_completo") + " ] ");
                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(ex);
        }
    }

    public static void borrarMensajeDB(Mensajes mensaje) {

        PreparedStatement ps = null;

        try (Connection conexion = dbConnect.getConnection()) {

            String query = "DELETE FROM mensajes WHERE id_mensaje = ? and id_usuario = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, mensaje.getId_mensaje());
            ps.setInt(2, mensaje.getId_usuario());
            ps.executeUpdate();
            System.out.println("El mensaje con ID " + mensaje.getId_mensaje() + " ha sido borrado");

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("No se pudo borrar el mensaje");
        }

    }

}
