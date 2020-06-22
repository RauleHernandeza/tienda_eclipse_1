package Servlets;

import Helpers.conexiondb;
import Helpers.hash;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Registro extends HttpServlet {

  private static final long serialVersionUID = 1L;
  String todo;
  Statement st;
  ResultSet rs;
  boolean n;
  
 
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
    }
//< > 
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String pass= request.getParameter("contrasx");
        hash ha= new hash(pass);
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.verificacion(request.getParameter("emailx"), ha.getTEST());
        if(con.respuesta()){
        response.sendRedirect("exit2.html");
        processRequest(request, response);
        }
        else{
        response.sendRedirect("error vuelva a intentar.html");
        processRequest(request, response);
        }

        con.cerrarconexion();
        
        
      } catch (NoSuchAlgorithmException ex) {
          Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
      }
       
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try {
        String pass= request.getParameter("contras");
        hash ha= new hash(pass);
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.crear(request.getParameter("email"),
        ha.getTEST(),request.getParameter("nombre"),request.getParameter("apellido"));
        con.cerrarconexion();
          
      } catch (NoSuchAlgorithmException ex) {
          Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
      }   
        processRequest(request, response);
        request.getRequestDispatcher("exit.html").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); 
        
    }
    

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.borrar(req.getParameter("emaill"), req.getParameter("contrass"));
        super.doDelete(req, resp); 
        req.getRequestDispatcher("exit.html").forward(req, resp);
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}