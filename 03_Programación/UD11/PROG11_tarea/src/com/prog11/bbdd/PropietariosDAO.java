package com.prog11.bbdd;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que contiene los métodos necesarios para realizar operaciones contra la tabla propietarios.
Como mejora, añado 2 métodos más (a parte de los del enunciado):uno para listar todos los propietarios y otro para listar los propietarios que no tienen vehículo
 */
public class PropietariosDAO {

    //Método para insertar un propietario. Se le pasa como parámetro la conexión y los datos del propietario.
    public static int insertarPropietario(Connection con, int id, String nombre, String DNI) throws SQLException {
        int devolucion = 0;
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO propietarios(id_prop,nombre_prop,dni_prop) VALUES(?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, nombre);
            pst.setString(3, DNI);
            pst.executeUpdate();

        } catch (SQLException e) {
            devolucion = -1;
        }
        ;
        return devolucion;
    }

    //Método para recuperar la lista de vehículos de un propietario. Se le pasa como parámetros la conexión y el DNI
    public static ArrayList recuperarVehiculosPropietario(Connection con, String DNI) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh FROM vehiculos v JOIN propietarios p ON p.id_prop=v.id_prop WHERE p.dni_prop=?");
            pst.setString(1, DNI);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                lista.add(" Matrícula: " + rs.getString(1) + ", marca: " + rs.getString(2) + ", km: " + rs.getString(3) + ", precio: " + rs.getString(4) + "\n");
            }
        } catch (SQLException e) {
            lista = null;
        }
        return lista;
    }

    ;
    
    //Método para borrar la información de un propietario. Se le pasa como parámetros la conexión y el DNI
    public static int borrarPropietario(Connection con, String DNI) throws SQLException {
        int numReg = 0;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM propietarios WHERE dni_prop= ?");
            pst.setString(1, DNI);
            numReg = pst.executeUpdate();
        } catch (SQLException e) {
            numReg = -1;
        }
        return numReg;
    }

    ;
    
    //Método para listar todos los propietarios
    public static ArrayList listarPropietarios(Connection con) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT id_prop,nombre_prop,dni_prop FROM propietarios");

        while (rs.next()) {
            lista.add(" ID: " + rs.getString(1) + ", nombre: " + rs.getString(2) + ", DNI: " + rs.getString(3) + "\n");
        }

        if (lista.isEmpty()) {
            lista.add("La lista de propietarios está vacía");
        }

        return lista;
    }

    //Método para listar los propietarios que no tienen vehículo
    public static ArrayList listarPropietariosSinVehiculo(Connection con) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT id_prop,nombre_prop,dni_prop FROM propietarios WHERE id_prop NOT IN(SELECT id_prop FROM vehiculos)");

        while (rs.next()) {
            lista.add(" ID: " + rs.getString(1) + ", nombre: " + rs.getString(2) + ", DNI: " + rs.getString(3) + "\n");
        }

        if (lista.isEmpty()) {
            lista.add("La lista de propietarios está vacía");
        }

        return lista;
    }

}
