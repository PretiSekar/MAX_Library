/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Preethi
 */
@WebServlet(urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

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
        String cardid = request.getParameter("BorrowerID");
        String ssn = request.getParameter("SSN");
        String fname = request.getParameter("FirstName");
	String lname = request.getParameter("LastName");
        String email = request.getParameter("Email");
	String address = request.getParameter("Address");
	String city = request.getParameter("City");
	String state = request.getParameter("State");
	String pno = request.getParameter("PhoneNo");

			int linect = 0;
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
                                System.out.print(cardid + "\t");
				System.out.print(ssn + "\t");
                                System.out.print(fname + "\t");
				System.out.print(lname + "\t");
				System.out.print(email + "\t");
				System.out.print(address + "\t");
				System.out.print(city + "\t");
                                System.out.print(state + "\t");
                                System.out.print(pno + "\t");
				System.out.println();
				// Execute a SQL query using SQL as a String object
                                String a="false";
                                String ssn1 = null;
                                String var;
                                ResultSet rs=stmt.executeQuery("SELECT ssn as ssn1 FROM borrower;");
                                
                                while(rs.next())
                                {
                                    var = rs.getString("ssn1");
                                    if(ssn.equals(var))
                                    {
                                        a="true";
                                        System.out.println("1");
                                    }
                                }
                                //String insert="INSERT INTO info VALUES('"+name+"','"+contactno+"');";
				//String sql="insert into borrower(card_id,ssn,fname,lname,email,address,city,state,phone) " + "values ('cardid','ssn','fname','lname','email','address','city','state','pno')";
                                if("false".equals(a))
                                {
                                String sql = "INSERT INTO BORROWER VALUES('"+cardid+"','"+ssn+"','"+fname+"','"+lname+"','"+email+"','"+address+"','"+city+"','"+state+"','"+pno+"');";
                                int result=stmt.executeUpdate(sql);
                                System.out.println(result);
                                }
                                else
                                {
                                    try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Result Page</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>Only One library card is allowed per borrower</h4>");
                                out.println("</body>");
                                out.println("</html>");
                                }
                                }
                                /* Alternatively, 'SELECT *' could be used */
				// ResultSet rs = stmt.executeQuery("SELECT * FROM employee;");

				// Iterate through the result set using ResultSet class's next() method
				/*while (rs.next()) {
					// Keep track of the line/tuple count
					linect++;
					// Populate field variables

					firstName = rs.getString("fname");
					m = rs.getString("minit");
					lastName = rs.getString("lname");
					ssn = rs.getString("KY");
					/* Alternative attribute value retrieval by column number */
					// column numbers are the same order as the SELECT statement from executeQuery
					// column numbers are integers that begin with 1
					// ssn = rs.getString(1);
					/*dno = rs.getString("dno");
					/* Alternative data type retrievals for Dno */
					// dno = rs.getInt("dno");
					// dno = Integer.parseInt(rs.getString("dno"));
					/*salary = rs.getString("salary");
					superSsn = rs.getString("super_ssn");

					// Do something with the data
					System.out.print(linect + ")\t");
					System.out.print(ssn + "\t");
					System.out.print(firstName + "\t");
                                        System.out.print(m + "\t");
					System.out.print(lastName + "\t");
					System.out.print(dno + "\t");
					System.out.print(salary + "\t");
					System.out.print(superSsn + "\t");
					System.out.println();
				} // End while(rs.next())*/

				// Always close the recordset and connection.
				//rs.close();
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
            out.println("<title>Servlet servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Succees!!");
            out.println("<h1>The borrower has been successfully added to the system</h1>");
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
