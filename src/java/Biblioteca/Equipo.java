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
import java.sql.ResultSet;
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
    private int canon, ext, hdmi, lcd, dvd, grab, tv, vhs;
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
        // JDBC driver name and database URL
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    String DB_URL = "jdbc:mysql://localhost:3306/biblioteca";

    //  Database credentials
    String USER = "root";
    String PASS = "";

    // Set response content type
    response.setContentType (
    "text/html");
      PrintWriter out = response.getWriter();
    String title = "Database Result";

    String docType
            = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

    out.println (docType 

    
        +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");
      try {
         // Register JDBC driver
         Class.forName("com.mysql.jdbc.Driver");

        // Open a connection
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Execute SQL query
        Statement stmt = conn.createStatement();
        String sql;
        sql = "SELECT * FROM biblioteca.pedidos";
        ResultSet rs = stmt.executeQuery(sql);

        // Extract data from result set
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("Id");
            String NombreProfesor = rs.getString("NombreProfesor");
            String NombreAlumnos = rs.getString("NombreAlumnos");
            int Matricula = rs.getInt("Matricula");
            String Plantel = rs.getString("Plantel");
            String Carrera = rs.getString("Carrera");
            String Grupo = rs.getString("Grupo");
            int Salon = rs.getInt("Salon");
            int Canon = rs.getInt("Canon");
            int Extencion = rs.getInt("Extencion");
            int Hdmi = rs.getInt("Hdmi");
            int Lcd = rs.getInt("Lcd");
            int Grabadora = rs.getInt("Grabadora");
            int Tv = rs.getInt("Tv");
            int Vhs = rs.getInt("Vhs");
            int Dvd = rs.getInt("Dvs");

            //Display values
            out.println("ID: " + id + "<br>");
            out.println(",Nombre Profesor: " + NombreProfesor + "<br>");
            out.println(",Nombre Alumnos: " + NombreAlumnos + "<br>");
            out.println(",Matricula: " + Matricula + "<br>");            
            out.println(",Plantel: " + Plantel + "<br>");
            out.println(",Carrera: " + Carrera + "<br>");
            out.println(",Grupo: " + Grupo + "<br>");
            out.println(",Salon: " + Salon + "<br>");
            out.println(",Canon: " + Canon + "<br>");
            out.println(",Extencion: " + Extencion + "<br>");
            out.println(",Hdmi: " + Hdmi + "<br>");
            out.println(",Lcd: " + Lcd + "<br>");            
            out.println(",Grabadora: " + Grabadora + "<br>");
            out.println(",Tv: " + Tv + "<br>");
            out.println(",Vhs: " + Vhs + "<br>");
            out.println(",Dvd: " + Dvd + "<br>");
        }
        out.println("</body></html>");

        // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
    }
    catch(SQLException se

    
        ) {
         //Handle errors for JDBC
         se.printStackTrace();
    }
    catch(Exception e

    
        ) {
         //Handle errors for Class.forName
         e.printStackTrace();
    }

    
        finally {
        //finally block used to close resources
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } //end finally try
    } //end try

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

        try {
        if (!request.getParameter("canon").isEmpty())
            canon = 1;
        else {canon = 0;}
        if (!request.getParameter("extencion").isEmpty())
            ext = 1;
        else {ext = 0;}
        if (!request.getParameter("hdmi").isEmpty())
            hdmi = 1;
        else {hdmi = 1;}
        if (!request.getParameter("lcd").isEmpty())
            lcd = 1;
        else {lcd = 1;}
        if (!request.getParameter("grabadora").isEmpty())
            grab = 1;
        else {grab = 0;}
        if (!request.getParameter("tv").isEmpty())
            tv = 1;
        else {tv = 0;}
        if (!request.getParameter("vhs").isEmpty())
            vhs = 1;
        else {vhs = 0;}
        if (!request.getParameter("dvd").isEmpty())
            dvd = 1;
        else {dvd = 0;}       
        }catch(NullPointerException e) { };
        
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=" + user + "&pasword=" + password);

            String query = String.format("INSERT INTO biblioteca.pedidos"
                    + "(NombreProfesor, NombreAlumnos, Matricula, Plantel, Carrera, Grupo, Salon, Canon, Extencion, Hdmi, Lcd, Grabadora, Tv, Vhs, Dvd) "
                    + "VALUES ('" + a + " ', '" + b + "', '" + c + "', '" + d + "', '" + e + "', '" + f + "', "
                            + "'" + g + "', '" + canon + "', '" + ext +"', '" + hdmi +"', '" +lcd+"', '"+grab+"', '" +tv+"', '"+vhs+"','"+dvd+"')");
            //processRequest(request, response);
            PreparedStatement st = conn.prepareStatement(query);
            st.execute();
            conn.close();

        

} catch (SQLException | ClassNotFoundException se) {
            Logger.getLogger(Connec.class
.getName()).log(Level.SEVERE, null, se);
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
