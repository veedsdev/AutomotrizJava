/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CRUD {

    Conexion con = new Conexion();

    public void insertarTrabajador(String nombre, String direccion) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "INSERT INTO TRABAJADORES (Nombre, Direccion, Ventas) VALUES ('" + nombre + "', '" + direccion + "', 0);";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro no se guardado correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarTrabajador(String nombre, String direccion, int id) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update TRABAJADORES set nombre = '" + nombre + "', direccion = '" + direccion + "' where id_t= " + id + ";";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualización incorrecta" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarTrabajador(int id) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "DELETE FROM TRABAJADORES WHERE id_T =" + id + ";";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminación incorrecta" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertarVehiculo(String nombre, String empresa, int cantidad) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "INSERT INTO VEHICULOS (Nombre, empresa, cantidad) VALUES ('" + nombre + "', '" + empresa + "', " + cantidad + ");";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Registro no se guardado correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarVehiculo(String nombre, String empresa, int cantidad, int id) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update VEHICULOS set nombre = '" + nombre + "', empresa = '" + empresa + "', cantidad =" + cantidad + "  where id_vehiculo= " + id + ";";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualización incorrecta" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void EliminarVehiculo(int id) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "DELETE FROM VEHICULOS WHERE id_vehiculo =" + id + ";";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminación incorrecta" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertarVentas(int id_t, int id_vehiculo, int cantidad) {

        try {
            Connection c = con.conectar();
            c = con.conectar();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("select*from VEHICULOS where Id_vehiculo= " + id_vehiculo + ";"); //RECIBE QUERY
            if (rs.next()) {
                if (Integer.parseInt(rs.getString("Cantidad")) > 0) {
                    try {
                        java.sql.Statement st2 = c.createStatement();
                        String sql = "INSERT INTO venta (id_t, id_vehiculo,Cantidad_vendidas) VALUES (" + id_t + "," + id_vehiculo + ", " + cantidad + ");";
                        st2.execute(sql);
                    st2.close();
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Registro no se guardado correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
                    }
            } else {
                JOptionPane.showMessageDialog(null, "Ya no hay vehiculos en stock", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
            }
        }
        st.close();
        c.close();
    }
    catch (SQLException ex

    
        ) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

}

public void actualizarVentas(int id_t, int id_vehiculo, int id_venta,int cantidad) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "update venta set id_t = " + id_t + ", id_vehiculo = " + id_vehiculo + ", Cantidad_vendidas = "+cantidad+" where id_venta= " + id_venta + ";";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Actualización incorrecta " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarVentas(int id) {
        try {
            Connection conexion = con.conectar();
            java.sql.Statement st = conexion.createStatement();
            String sql = "DELETE FROM VENTA WHERE id_venta =" + id + ";";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Eliminacion incorrecta " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
}
