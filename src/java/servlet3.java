/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Preethi
 */
@WebServlet(urlPatterns = {"/servlet3"})
public class servlet3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    static Connection conn = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String bid = request.getParameter("bid");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String todaydate = sdf.format(c.getTime());
        String a,b,d,e,f,g;
        System.out.println(todaydate);
        try {			
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecttest1?useSSL=false", "root", "root");
				Statement stmt = conn.createStatement();
				stmt.execute("use projecttest1;");
				System.out.print(bid + "\t");
				System.out.println();
                                ResultSet rs=stmt.executeQuery("select * from book_loans where card_id='"+bid+"' and due_date<'"+todaydate+"' and date_in='null' ;");
                                try (PrintWriter out = response.getWriter()) {
                                /* TODO output your page here. You may use following sample code. */
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Result Page</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("loan_id"+"isbn"+"card_id"+"date_out"+"due_date"+"date_in");
                                while(rs.next())
                                {
                                
                                a=rs.getString("loan_id");
                                System.out.println(a);
                                b=rs.getString("isbn");
                                System.out.println(b);
                                d=rs.getString("card_id");
                                System.out.println(d);
                                e=rs.getString("date_out");
                                System.out.println(e);
                                f=rs.getString("due_date");
                                System.out.println(f);
                                //System.out.println("sjhdghgshfj");
                                g=rs.getString("date_in");
                                System.out.println(g);
                                out.println("<h4>"+a+""+b+""+d+""+e+""+f+""+g+"</h4>");
                                
                                } 
                                out.println("</body>");
                                out.println("</html>");
                        }
			
                                rs.close();
				conn.close();
				System.out.println("Success!!");
			} 
			catch(SQLException ex) {
				System.out.println("Error in connection: " + ex.getMessage());
                                try (PrintWriter out = response.getWriter()) {
                                /* TODO output your page here. You may use following sample code. */
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Result Page</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>Error in connection+'"+ex.getMessage()+"'</h4>");
                                out.println("</body>");
                                out.println("</html>");
                        }
			}
               
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet3 at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
