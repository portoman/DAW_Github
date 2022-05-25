package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
Autor: Jesús Alfonso Porto Bujía
Descripción: Clase que contiene los métodos necesarios para realizar operaciones contra la tabla vehículos.
Incluyo como mejora un metódo para listar los coches con los precios igual o inferiores al valor dado.
 */
public class VehiculosDAO {

    //Método para insertar un vehículo. Se le pasa como parámetro la conexión y los datos del vehículo
    public static int insertarVehiculo(Connection con, String matricula, String marca, int km, float precio, String descuento, int idPropietario) throws SQLException {
        int devolucion = 0;
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO vehiculos VALUES(?,?,?,?,?,?)");
            pst.setString(1, matricula);
            pst.setString(2, marca);
            pst.setInt(3, km);
            pst.setFloat(4, precio);
            pst.setString(5, descuento);
            pst.setInt(6, idPropietario);
            pst.executeUpdate();
        } catch (SQLException e) {
            devolucion = -1;
        }
        ;
        return devolucion;
    }

    //Método que actualiza el propietario de un vehículo. Recibe la matrícula y el id del propietario
    public static int actualizarPropietarioVehículo(Connection con, String matricula, int idPropietario) throws SQLException {
        int devolucion = 0;
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE vehiculos SET id_prop=? WHERE mat_veh=?");
            pst.setInt(1, idPropietario);
            pst.setString(2, matricula);
            pst.executeUpdate();
        } catch (SQLException e) {
            devolucion = -1;
        }
        ;
        return devolucion;
    }

    //Método para borrar un vehículo. Se le pasa como parámetros la conexión y la matrícula
    public static int borrarVehiculo(Connection con, String matricula) throws SQLException {
        int numReg = 0;
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM vehiculos WHERE mat_veh=?");
            pst.setString(1, matricula);
            numReg = pst.executeUpdate();

        } catch (SQLException e) {
            numReg = 0;
        }

        return numReg;
    }

    //Método para recuperar la siguiente información de todos los vehículos: matrícula, marca, kilómetros y precio de cada vehículo 
    public static ArrayList recuperarTodosVehiculos(Connection con) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh,v.desc_veh,p.nombre_prop FROM vehiculos v JOIN propietarios p ON p.id_prop=v.id_prop");

        while (rs.next()) {
            lista.add(" Matrícula: " + rs.getString(1) + ", marca: " + rs.getString(2) + ", kms: " + rs.getString(3) + ", precio: " + rs.getString(4) + " €, descuento: " + rs.getString(5) + ", propietario: " + rs.getString(6) + "\n");
        }

        if (lista.isEmpty()) {
            lista.add("La lista de vehículos está vacía");
        }

        return lista;
    }

    //Método para recuperar vehiculos por marca
    public static ArrayList recuperarVehiculosMarca(Connection con, String marca) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();

        PreparedStatement pst = con.prepareStatement("SELECT v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh,v.desc_veh,p.nombre_prop FROM vehiculos v JOIN propietarios p ON p.id_prop=v.id_prop WHERE v.marca_veh=?");
        pst.setString(1, marca);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            lista.add(" Matrícula: " + rs.getString(1) + ", marca: " + rs.getString(2) + ", kms: " + rs.getString(3) + ", precio: " + rs.getString(4) + " €, descuento: " + rs.getString(5) + ", propietario: " + rs.getString(6) + "\n");
        }

        if (lista.isEmpty()) {
            lista.add("La lista de vehículos está vacía");
        }

        return lista;
    }

    //Método para recuperar la siguiente información de todos los vehículos: matrícula, marca, kilómetros y precio de cada vehículo 
    public static ArrayList recuperarVehiculos(Connection con) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh FROM vehiculos v JOIN propietarios p ON p.id_prop=v.id_prop");

        while (rs.next()) {
            lista.add(" Matrícula: " + rs.getString(1) + ", marca: " + rs.getString(2) + ", kms: " + rs.getString(3) + ", precio: " + rs.getString(4) + " €.\n");
        }

        if (lista.isEmpty()) {
            lista.add("La lista de vehículos está vacía");
        }

        return lista;
    }

    //Metódo para listar los coches con los precios igual o inferiores al valor dado
    public static ArrayList recuperarVehiculosPrecioInferior(Connection con, int precio) throws SQLException {
        ArrayList<String> lista = new ArrayList<String>();

        PreparedStatement pst = con.prepareStatement("SELECT v.mat_veh,v.marca_veh,v.kms_veh,v.precio_veh,v.desc_veh,p.nombre_prop FROM vehiculos v JOIN propietarios p ON p.id_prop=v.id_prop WHERE v.precio_veh<=?");
        pst.setInt(1, precio);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            lista.add(" Matrícula: " + rs.getString(1) + ", marca: " + rs.getString(2) + ", kms: " + rs.getString(3) + ", precio: " + rs.getString(4) + " €.\n");
        }

        if (lista.isEmpty()) {
            lista.add("La lista de vehículos está vacía");
        }
        return lista;
    }
;

}
