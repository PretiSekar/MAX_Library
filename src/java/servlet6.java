/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet(urlPatterns = {"/servlet6"})
public class servlet6 extends HttpServlet {

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
    String btitle,bpresent,bisbn,aauthor;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String searchstring = request.getParameter("namesearch");
        System.out.println(searchstring);
        System.out.println("hello 123");
                    try {			
            try {
                // Create a connection to the local MySQL server, with the "company" database selected.
                //        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
                // Create a connection to the local MySQL server, with the NO database selected.
                //Class.forName("com.mysql.jdbc.Driver");
                                    Class.forName("com.mysql.jdbc.Driver");
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
                                }
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecttest1?useSSL=false", "root", "root");

				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
				// Set the current database, if not already set in the getConnection
				// Execute a SQL statement
				// String chooseDatabase = "use company;"
				stmt.execute("use projecttest1;");
                                System.out.println();
				ResultSet rs=stmt.executeQuery("SELECT book.isbn,title,present,author_name FROM book,authors,book_authors where book.isbn=book_authors.isbn and authors.author_id=book_authors.author_id and (book.title LIKE '%" + searchstring + "%' OR authors.author_name LIKE '%"+ searchstring +"%' OR book.isbn LIKE '%"+ searchstring+"%');");
                                try (PrintWriter out = response.getWriter()) {
                                /* TODO output your page here. You may use following sample code. */
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Result Page</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>"+"ISBN"+"&nbsp;"+"title"+"&nbsp;"+"present"+"&nbsp;"+"author_name"+"</h4>");
                                while(rs.next())
                                {
                                bisbn=rs.getString("isbn");
                                System.out.println(bisbn);
                                btitle=rs.getString("title");
                                System.out.println(btitle);
                                bpresent=rs.getString("present");
                                System.out.println(bpresent);
                                aauthor=rs.getString("author_name");
                                System.out.println(aauthor);
                                out.println("<h4>"+bisbn+"\t"+btitle+"\t"+bpresent+"\t"+aauthor+"</h4>");
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
                                out.println("<h4>Error: " + ex.getMessage() + "</h4>");
                                out.println("</body>");
                                out.println("</html>");
                            }
			}
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet search at " + request.getContextPath() + "</h1>");
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
