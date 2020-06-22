package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class conexiondb {
    boolean error;
    Connection conexion = null;
    PreparedStatement st=null;
    ResultSet rs=null;
    String todo=null;
    boolean ee=false;
    String dd=null;
    String ddd= null;
    String w=null;
 ////////////////////////////////////////////////////////////////////////////////////   
     public Connection DBConnection() {
		 try {
            //Establecer datos de conexion
            Class.forName("org.postgresql.Driver");
            String  url="jdbc:postgresql://localhost:5432/conexion";
            conexion = DriverManager.getConnection(url,"Raul","Raul");
		}
		 catch (SQLException e) {
			System.out.println("Ha ocurrido el siguiente error con la BD:" + e.getMessage());
			error = true;
		}catch(ClassNotFoundException ex) {
            System.out.print("Ocurri� un error con los drivers.");
            error = true;
            }
	 return conexion;
   	 }   
         
//////////////////////////////////////////////////////////////////////////////////////
      public Connection cerrarconexion() { 
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      return conexion;
      }

    ////////////////////////////////////////////////////////////////////////////////////  
      public void crear(String c, String d, String e, String b){
          
        try {
            st = conexion.prepareCall("INSERT INTO usuario VALUES(?, ?, ?, ?, false)");
            st.setString(1, c);
            st.setString(2, d);
            st.setString(3, e);
            st.setString(4, b);
            rs = st.executeQuery();
            
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
      }
      //////////////////////////////////////////////////////////////////////////////////////
      
      public void borrar (String j, String m){
          
        try {
            st = conexion.prepareCall("DELETE FROM usuario WHERE email= ? and contras = ?");
            st.setString(1, j);
            st.setString(2, m);
            rs = st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      ////////////////////////////////////////////////////////////////////////////////////////
      
      public void actualizar(String c, String d, String e, String b, String a, String f){
      try {
            st = conexion.prepareCall("UPDATE usuario SET email= ?, contras= ?, nombre= ?, apellido= ? WHERE contras= ? AND email= ?");
            st.setString(1, c);
            st.setString(2, d);
            st.setString(3, e);
            st.setString(4, b);
            st.setString(5, a);
            st.setString(6, f);
            System.out.println(c);
            System.out.println(d);
            System.out.println(e);
            System.out.println(b);
            System.out.println(a);
            System.out.println(f);
            rs = st.executeQuery();
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      
      //////////////////////////////////////////////////////////////////////////////////////
      public void verificacion(String c, String d){
        try {
            st = conexion.prepareCall("SELECT * FROM usuario WHERE email=? AND contras=?");
            st.setString(1, c);
            st.setString(2, d);
            rs = st.executeQuery();
            if(rs.next()==!false){
            ee=true;
            }
            else{
            ee=false;
            }
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }  
      }
  //////////////////////////////////////////////////////////////////////////////////////
      public void verificacion2(String c, String d){
        try {
            String ra="raguna@gmail.com";
            String ra2="14f0dc12357f28dc45721bf65e408e9e5c7258683ec2eb37ecfb3534bd5733";
            System.out.println(c);
            System.out.println(d);
            if(ra.equals(c) && ra2.equals(d)){
            st = conexion.prepareCall("SELECT * FROM usuario WHERE email=? AND contras=?");
            st.setString(1, c);
            st.setString(2, d);
            rs = st.executeQuery();
            if(rs.next()==!false){
            ee=true;
            }
            else{
            ee=false;
                 }
            }
            else{
            System.out.println("error en el ingreso de usuario");
            ee=false;
            }
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        }  
      }
      
      //////////////////////////////////////////////////////////////////////////////////////
      public boolean respuesta(){
      return ee;
      }
     ////////////////////////////////////////////////////////////////////////////////////  
      public void crearp(String c, String d, String e){
          
        try {
            st = conexion.prepareCall("INSERT INTO productos VALUES(?, 'raguna@gmail.com', 'motoo', ?, ?)");
            st.setString(1, c);
            st.setString(2, d);
            st.setString(3, e);
            rs = st.executeQuery();
            
        } catch (SQLException ex ) {
            Logger.getLogger(conexiondb.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
      }
}

