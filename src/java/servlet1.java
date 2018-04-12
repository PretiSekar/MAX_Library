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
@WebServlet(urlPatterns = {"/servlet1"})
public class servlet1 extends HttpServlet {

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
        String isbn1 = request.getParameter("isbn");
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String dateout = sdf.format(c.getTime());// Now use today date.
        String todaydate = sdf.format(c.getTime());//today's date
        c.add(Calendar.DATE, 14); // Adding 14 days
        String duedate = sdf.format(c.getTime());
        String datein="null";  
        int linect = 0;
        System.out.println("hello 123");
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
				System.out.print(isbn1 + "\t");
                                System.out.println(dateout);
                                System.out.println(duedate);
                                System.out.println(datein);
				System.out.println();
                                ResultSet rs=stmt.executeQuery("SELECT present FROM book where book.isbn='"+isbn1+"';");
                                rs.next();
                                //if book is present
                                String a=rs.getString("present");
                                System.out.println(a);
                                //to the check that the borrower can take only a maximum of 3 books
                                rs=stmt.executeQuery("select count(*) as maxcount from book_loans where card_id='"+bid+"'and date_in='null';");
                                rs.next();
                                int b=rs.getInt("maxcount");
                                System.out.println(b);
                                //check if there are books overdue for a borrower
                                rs=stmt.executeQuery("select count(*) as bocount from book_loans where card_id='"+bid+"' and due_date<'"+todaydate+"' and date_in='null';");
                                rs.next();
                                System.out.println(todaydate);
                                System.out.println(bid);
                                String l=rs.getString("bocount");
                                System.out.println("Prints if there is a loanid for overdue book");
                                System.out.println(l);
                                //check if unpaid fine
                                rs=stmt.executeQuery("select count(*) from fines,book_loans,borrower where fines.loan_id=book_loans.loan_id and book_loans.card_id=borrower.card_id and borrower.card_id='"+bid+"' and paid=0;");
                                rs.next();
                                String fi=rs.getString("count(*)");
                                System.out.println("Prints if there us an fine existing");
                                System.out.println(fi);
                                if("0".equals(fi))
                                {
                                if("0".equals(l))
                                {
                                
                                if(b<3)
                                {
                                if("1".equals(a))
                                {
                                String sql = "INSERT INTO BOOK_LOANS VALUES('"+0+"','"+isbn1+"','"+bid+"','"+dateout+"','"+duedate+"','"+datein+"');";
                                int result=stmt.executeUpdate(sql);
                                System.out.println(result);
                                String p="0";
                                PreparedStatement ps = conn.prepareStatement("UPDATE BOOK SET present = ? WHERE isbn = ?");
                                // set the preparedstatement parameters
                                ps.setString(1,p);                             
                                ps.setString(2,isbn1);
                                // call executeUpdate to execute our sql update statement
                                ps.executeUpdate();
                                ps.close();
                                }
                                else 
                                {
                                System.out.println("The book is not available");
                                try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                                    out.println("<!DOCTYPE html>");
                                    out.println("<html>");
                                    out.println("<head>");
                                    out.println("<title>Result Page</title>");            
                                    out.println("</head>");
                                    out.println("<body>");
                                    out.println("<h4>The book is not available</h4>");
                                    out.println("</body>");
                                    out.println("</html>");
                                }
                                }
                                }
                                
                                else
                                {
                        try (PrintWriter out = response.getWriter()) {
                                System.out.println("The borrower has exceeded the limit");
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>ResultPage</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>The borrower has exceeded the limit</h4>");
                                out.println("</body>");
                                out.println("</html>");
                                }
                                }
                                }
                                else
                                {
                                System.out.println("Borrower has an overdue book");
                                try (PrintWriter out = response.getWriter()) {
                                System.out.println("Borrower has an overdue book");
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>ResultPage</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>Borrower has an overdue book</h4>");
                                out.println("</body>");
                                out.println("</html>");
                                }
                                }
                                }
                                else
                                {
                                try (PrintWriter out = response.getWriter()) {
                                System.out.println("Borrower has to pay a fine");
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>ResultPage</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>Borrower has to pay a fine</h4>");
                                out.println("</body>");
                                out.println("</html>");
                                }
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
            out.println("<title>Result Page</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>The book has been successfully checked out</h4>");
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
