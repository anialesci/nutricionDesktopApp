/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alesci.nutricion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author netosolis.com
 */
public class CRUD {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUD() {
        try{
            if((con = conexion.getConexionMYSQL())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Inserta una nueva pelicula en la Base de Datos
    public boolean insert(String nombre,int edad,String telefono,
            String direccion,int peso, int tallaCentrimetros,String ubicacion, String condicionBase, String medicamentos, int cribaje, float evaluacion, float evaluacionGlobal){
        try {
            String query = "INSERT INTO pacientes VALUES(NULL,'"+nombre+"','"+edad+"','"+telefono+"','"+direccion+"','"+peso+"','"+tallaCentrimetros+"','"+ubicacion+"','"+condicionBase+"','"+medicamentos+"','"+cribaje+"','"+evaluacion+"','"+evaluacionGlobal+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Devuelve el resultset con los datos de peliculas
    public ResultSet selectXtodas(){
        try {
            String query = "SELECT * FROM pacientes ORDER BY nombre ASC";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //Devuelve el resultset con los datos de peliculas con select por genero
    public ResultSet selectXgenero(String genero){
        try {
            String query = "SELECT * FROM peliculas WHERE genero = '"+genero+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    //Devuelve el resultset con los datos de peliculas con select por pais
    public ResultSet selectXId(int id){
        try {
            String query = "SELECT * FROM pacientes WHERE id = '"+id+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        
    //Elimina la pelicula
    public boolean delete(int id){
        try {
            String query = "DELETE FROM pacientes WHERE id = '"+id+"'";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //Actualiza los datos del paciente
    public boolean update(int id,String nombre,int edad,String telefono,
            String direccion, int peso, int tallaCentimetros, String ubicacion, String condicionBase, String medicamentos){
        try {
            String query = "UPDATE pacientes SET"
                    + " nombre = '"+nombre+"',"
                    + " edad = '"+edad+"',"
                    + " telefono = '"+telefono+"',"
                    + " direccion = '"+direccion+"',"
                    + " peso = '"+peso+"',"
                    + " tallaCentimetros = '"+tallaCentimetros+"',"
                    + " ubicacion = '"+ubicacion+"',"
                    + " condicionBase = '"+condicionBase+"',"
                    + " medicamentos = '"+medicamentos+"' WHERE id = '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

 public boolean updateCribaje(int id,int cribaje){
        try {
            String query = "UPDATE pacientes SET"
                    + " cribaje = '"+cribaje+"' WHERE id = '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

 public boolean updateEvaluacion(int id,float evaluacion){
        try {
             String query = "UPDATE pacientes SET"
                    + " evaluacion = '"+evaluacion+"' WHERE id = '"+id+"';";
           
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
public boolean updateEvaluacionGlobal(int id,float evaluacionGlobal){
        try {
             String query = "UPDATE pacientes SET"
                    + " evaluacionGlobal = '"+evaluacionGlobal+"' WHERE id = '"+id+"';";
           
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
