package alesci.nutricion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author netosolis.com
 */
public class Conexion {
    //Configuracion de los datos de la BD
    private String usuario = "sql10617418";
    private String pass = "lrpIsi9iHC";
    private String host = "sql10.freemysqlhosting.net:3306";
    private String nombre_BD = "sql10617418";
    
    private Connection con = null;
    
    public Conexion() {
    }
    //Metodo que se devuelve la conexion o null si hubo un error
    public Connection getConexionMYSQL(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,usuario,pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
}
