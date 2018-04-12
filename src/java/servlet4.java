/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import static java.util.concurrent.TimeUnit.DAYS;
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
@WebServlet(urlPatterns = {"/servlet4"})
public class servlet4 extends HttpServlet {

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String p = sdf.format(c.getTime());//today's date
        System.out.println(isbn1);
        System.out.println(bid);
        System.out.println(p);
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
                                PreparedStatement ps = conn.prepareStatement("UPDATE BOOK_LOANS SET date_in = ? WHERE isbn = ? and card_id = ?");
                                // set the preparedstatement parameters
                                ps.setString(1,p);                             
                                ps.setString(2,isbn1);
                                ps.setString(3,bid);
                                // call executeUpdate to execute our sql update statement
                                System.out.println(ps);
                                ps.executeUpdate();
                                String p1="1";
                                ps = conn.prepareStatement("UPDATE BOOK SET present = ? WHERE isbn = ?");
                                // set the preparedstatement parameters
                                ps.setString(1,p1);                             
                                ps.setString(2,isbn1);
                                // call executeUpdate to execute our sql update statement
                                ps.executeUpdate();
                                
                                //if toodays date >dur date then create fines record
                                ResultSet rs=stmt.executeQuery("select due_date from book_loans where card_id='"+bid+"' and isbn='"+isbn1+"' ;");
                                rs.next();
                                String duedate=null;
                                duedate=rs.getString("due_date");
                                System.out.println(duedate);
                                System.out.println(p);
                                //boolean comp=sdf.parse(duedate).before(sdf.parse(p));
                                //System.out.println(sdf.parse(p).before(sdf.parse(duedate)));
                                //System.out.println("Days= "+daysBetween(cal1.getTime(),cal2.getTime()));
                                int compareTo = p.compareTo(duedate);
                                System.out.println(compareTo);
                                
                                if(compareTo>0)
                                {
                                String loan = null;
                                rs=stmt.executeQuery("select loan_id from book_loans where card_id='"+bid+"' and isbn='"+isbn1+"' ;");
                                rs.next();
                                loan=rs.getString("loan_id");
                                System.out.println(loan);
                                //Date z1= SimpleDateFormat.parse(p);
                                //Date z2= SimpleDateFormat.parse(duedate);
                                //int abcd= (int) ((z1.getTime() - z2.getTime()) / (1000 * 60 * 60 * 24));
                                
                                //int days = Days.daysBetween(p, duedate).getDays();
                                //long daysBetween = DAYS.between(p, duedate);
                                 //
                                 Date date1 = null;
                                 Date date2 = null;
                                    try {
                                        date2 = sdf.parse(p);
                                        date1 = sdf.parse(duedate);
                                    } catch (ParseException ex) {
                                        Logger.getLogger(servlet4.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                int diffInDays = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
                                int fineamount=(int) (diffInDays*0.25);
                                System.out.println("aaaaa"+diffInDays);
                                String sql = "INSERT FINES VALUES('"+loan+"','"+fineamount+"',0);";
                                int result=stmt.executeUpdate(sql);
                                System.out.println(result);
                                }
                                ps.close();
                                conn.close();
				System.out.println("Success!!");
                                try (PrintWriter out = response.getWriter()) {
                                /* TODO output your page here. You may use following sample code. */
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Result Page</title>");            
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<h4>The book has been checked in</h4>");
                                out.println("</body>");
                                out.println("</html>");
                        }
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
            out.println("<title>Servlet servlet4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servlet4 at " + request.getContextPath() + "</h1>");
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
