package proposto03i;

import java.sql.*;
import java.util.ArrayList;

public class Datos {

    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/datos?user=root&password=admin");
        } catch (SQLException ex) {
            System.out.println("Non se puido facer a conexión");
            System.out.println(ex.getMessage());
        }
        return con;
    }

    //Método para leer los datos de la base de datos que devuelve un Resulset: conjunto de filas resultantes
    public static ResultSet ler(Connection con) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM persoas");

        } catch (SQLException ex) {
            System.out.println("Non se puido facer a consulta");
            System.out.println(ex.getMessage());
        }
        return rs;
    }

    public static void escribir(Persoa persoa, Connection con) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO persoas VALUES(?,?)");
            pst.setString(1, persoa.getNome());
            pst.setInt(2, persoa.getIdade());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Non foi posible executar a inserción");
            System.out.println(ex.getMessage());
        }
    }

    //Método que devuelve un objeto cálculos a partir del resultado de una query
    public static Calculos estatistica(Connection con) {
        Calculos calculos = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) a, MAX(idade) b,"
                    + " MIN(idade) c, AVG(idade) d"
                    + " FROM persoas"
            );
            //If en vez de where, porque va a ser solo una consulta
            if (rs.next()) {
                //Metemos el resultado de la query en un objeto calculos
                calculos = new Calculos(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4));
            }
        } catch (SQLException ex) {
            System.out.println("Non foi posible executar a consulta");
            System.out.println(ex.getMessage());
        }
        return calculos;
    }
}
