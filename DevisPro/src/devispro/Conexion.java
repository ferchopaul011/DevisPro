/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devispro;
import java.sql.*;

/**
 *
 * @author Crixo
 */
public class Conexion {
    //JDBC driver name  y url base de datos
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/devispro" ;
    //Credenciales BD
    static final String USER = "root";
    static final String PASS = "root";
    
    public static Connection getConnection(){
       Connection conn = null;
        try {
            //Registro del driver JDBC 
            Class.forName("com.mysql.jdbc.Driver");
            //abrir la coneccion
            //System.out.println("Conectando la base ......");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
        } catch (SQLException se) {
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            /*try {
                if(conn!= null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }*/
        }
        //System.out.println("Adios...");
        return conn;
    }
            public static ResultSet getTable(String Consulta){
                Connection conn = getConnection();
                Statement st;
                ResultSet datos = null;
                try {
                    st=conn.createStatement();
                    datos=st.executeQuery(Consulta);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                }
       
                return datos;

}
    
}


