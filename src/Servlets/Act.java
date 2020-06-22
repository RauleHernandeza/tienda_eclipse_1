package Servlets;

import Helpers.conexiondb;
import Helpers.hash;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Act extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	String dd;
    String ddd;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
       String b=request.getParameter("contras");
       ddd=request.getParameter("email");
        try {
            hash a= new hash(b);
            dd=a.getTEST();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Act.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(dd);
        System.out.println(ddd);
        request.getRequestDispatcher("PUT.html").forward(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              try {
        String pas= request.getParameter("contras");
        hash as= new hash(pas);
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.actualizar(request.getParameter("email"),as.getTEST(),
        request.getParameter("nombre"), request.getParameter("apellido"), dd, ddd);
        con.cerrarconexion();
      } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
      }
      

        
        processRequest(request, response);
        request.getRequestDispatcher("exit.html").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}