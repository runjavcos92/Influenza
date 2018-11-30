/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.*;

/**
 *
 * @author FRANCISCONAVA
 */
public class conectar {
    public Connection conectar(){
        String direccion = "127.0.0.1";
        String puerto = "1433";
        String db = "INFLUENZA18"; 
        String usuario = "sa";
        String pass = "admin"; //develop sql pass: 'admin', prodcutive sql pass: 'Admin2017'
        String connectionUrl = "jdbc:sqlserver://" + direccion + ":" + puerto + ";"
                + "databaseName=" + db + ";user=" + usuario + ";password=" + pass + ";";
        
        //System.out.println(""+connectionUrl);
        // Declaramos los sioguientes objetos
        Connection con = null;
        try {
            //Establecemos la conexión
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }  
}
