package Servlets;

import Helpers.conexiondb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Actt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        conexiondb con = new conexiondb();
        con.DBConnection();
        con.crearp(request.getParameter("id"),request.getParameter("descrip"),request.getParameter("cate"));
        con.cerrarconexion();
        processRequest(request, response);
        request.getRequestDispatcher("exit.html").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
