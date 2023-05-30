/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {

    Connection con = null;
    String url = "jdbc:postgresql://localhost/Automotriz";
    String usuario = "postgres";
    String clave = "1234";

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, clave);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
}
