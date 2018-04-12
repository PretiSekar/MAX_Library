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
@WebServlet(urlPatterns = {"/servlet2"})
public class servlet2 extends HttpServlet {

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
        String fine = request.getParameter("fine");
        int linect = 0;
        int a,b;
        boolean c;
        System.out.println("hello 123");
                    try {			
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            } 
                        catch (ClassNotFoundException ex) {
                                Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
                            }
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecttest1?useSSL=false", "root", "root");

				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
				// Set the current database, if not already set in the getConnection
				// Execute a SQL statement
				// String chooseDatabase = "use company;"
				stmt.execute("use projecttest1;");
                                System.out.print(bid + "\t");
				System.out.print(fine + "\t");
				System.out.println();
                                if("both".equals(fine))
                                {
				ResultSet rs=stmt.executeQuery("select fines.loan_id,fine_amt,paid from fines,book_loans,borrower where fines.loan_id=book_loans.loan_id and book_loans.card_id=borrower.card_id and borrower.card_id='"+bid+"';");
                                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>Result Page</title>");            
                                        out.println("</head>");
                                        out.println("<body>");
                                        out.println("<h4>" +"LoanID"+"\t"+"Amount"+"\t"+"Paid"+ "</h4>");
                                while(rs.next())
                                {
                            
                                    a=rs.getInt("loan_id");
                                    b=rs.getInt("fine_amt");
                                    c=rs.getBoolean("paid");
                                    System.out.println(a);
                                    System.out.println(b);
                                    System.out.println(c);
                                    out.println("<h4>" +a+"\t"+"\t"+"\t"+b+"\t"+"\t"+"\t"+c+"</h4>");
                                }
                                
                                        out.println("</body>");
                                        out.println("</html>");
                            }
                                }
                                else if ("unpaid".equals(fine))
                                {
                                    ResultSet rs=stmt.executeQuery("select fines.loan_id,fine_amt,paid from fines,book_loans,borrower where fines.loan_id=book_loans.loan_id and book_loans.card_id=borrower.card_id and borrower.card_id='"+bid+"' and paid=0;");
                                    try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>Result Page</title>");            
                                        out.println("</head>");
                                        out.println("<body>");
                                        out.println("<h4>" +"LoanID"+"\t"+"Amount"+"\t"+"Paid"+ "</h4>");
                                    while(rs.next())
                                    {

                                        a=rs.getInt("loan_id");
                                        b=rs.getInt("fine_amt");
                                        c=rs.getBoolean("paid");
                                        System.out.println(a);
                                        System.out.println(b);
                                        System.out.println(c);
                                        out.println("<h4>" +a+"\t"+"\t"+"\t"+b+"\t"+"\t"+"\t"+c+"</h4>");
                                    }
                                    out.println("</body>");
                                        out.println("</html>");
                            }
                                }
                                else
                                {
                                    ResultSet rs=stmt.executeQuery("select fines.loan_id,fine_amt,paid from fines,book_loans,borrower where fines.loan_id=book_loans.loan_id and book_loans.card_id=borrower.card_id and borrower.card_id='"+bid+"'and paid=1;");
                                    try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                                        out.println("<!DOCTYPE html>");
                                        out.println("<html>");
                                        out.println("<head>");
                                        out.println("<title>Result Page</title>");            
                                        out.println("</head>");
                                        out.println("<body>");
                                        out.println("<h4>" +"LoanID"+"\t"+"Amount"+"\t"+"Paid"+ "</h4>");
                                        while(rs.next())
                                    {

                                        a=rs.getInt("loan_id");
                                        b=rs.getInt("fine_amt");
                                        c=rs.getBoolean("paid");
                                        System.out.println(a);
                                        System.out.println(b);
                                        System.out.println(c);
                                        out.println("<h4>" +a+"\t"+"\t"+"\t"+b+"\t"+"\t"+"\t"+c+"</h4>");
                                    }
                                        out.println("</body>");
                                        out.println("</html>");
                            }
                                }
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
            out.println("<title>Servlet servlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet2 at " + request.getContextPath() + "</h1>");
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
