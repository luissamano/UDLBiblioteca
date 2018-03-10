/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;

import Conexion.Connec;
import Model.Biblioteca;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marti
 */
public class Equipo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String a, b, c, d, e, f, g, h, i, j;
    private Connection conn;
    String user = "root";
    String password = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html >");
            out.println("<head>");
            out.println("<title>Servlet Equipo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Equipo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        a = request.getParameter("inputProfesor");
        b = request.getParameter("inputAlumno");
        c = request.getParameter("inputMatricula");
        d = request.getParameter("inputPlantel");
        e = request.getParameter("inputCarrera");
        f = request.getParameter("inputGrupo");
        g = request.getParameter("inputSalon");

        //        List<String> list = new ArrayList<String>();
//
//        Enumeration nombresParams = request.getParameterNames();
//        while (nombresParams.hasMoreElements()) {
//            String param = (String) nombresParams.nextElement();
//            String valor = request.getParameter(param);
//            list.add(valor+"");
//        }
//
//        response.setContentType("application/json;charset=UTF-8");
//        String json = new Gson().toJson(list);
//        response.getWriter().write(json);
        try {

            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bilblioteca?user=" + user + "&pasword=" + password);

            
            String query = String.format("INSERT INTO bilblioteca.solicitudes"
                    + "(NombreProfesor, NombreAlumnos, Matricula, Plantel, Carrera, Grupo, Salon) "
                    + "VALUES ('" + a + " ', '" + b + "', '" + c + "', '" + d + "', '" + e + "', '" + f + "', '" + g + "')");
            //processRequest(request, response);
            PreparedStatement st = conn.prepareStatement(query);
            st.execute();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException se) {
            Logger.getLogger(Connec.class.getName()).log(Level.SEVERE, null, se);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
