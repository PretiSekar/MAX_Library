/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Preethi
 */
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CompanyTest {
    static Connection conn = null;
        /**
         * @param args
         */
        public static void main(String[] args) throws ClassNotFoundException {
			// Initialize variables for fields by data type
			String ssn;
			String firstName;
			String m;
			String lastName;
			String address;
			String dno;
			/* The Java dno variable may also be type int
			 * Note that the SQL data type may be different
			 * than the wrapper language data type!!
			 */
			// int dno; 
			String salary;
			String superSsn;

			int linect = 0;

			try {
				// Create a connection to the local MySQL server, with the "company" database selected.
				//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
				// Create a connection to the local MySQL server, with the NO database selected.
                                //Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company9?useSSL=false", "root", "root");

				// Create a SQL statement object and execute the query.
				Statement stmt = conn.createStatement();
        
				// Set the current database, if not already set in the getConnection
				// Execute a SQL statement
				// String chooseDatabase = "use company;"
				stmt.execute("use company9;");

				/* Here is another query that returns the results of "SHOW SCHEMA" */
				// ResultSet r = stmt.executeQuery("show schemas;");
				// while(r.next()) {
				// 	System.out.println(r.getString("Database"));
				// }

				// Execute a SQL query using SQL as a String object
				ResultSet rs = stmt.executeQuery("SELECT Ssn AS KY, Fname, Minit, Lname, Dno, Salary, Super_ssn FROM employee;");
				/* Alternatively, 'SELECT *' could be used */
				// ResultSet rs = stmt.executeQuery("SELECT * FROM employee;");

				// Iterate through the result set using ResultSet class's next() method
				while (rs.next()) {
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
					dno = rs.getString("dno");
					/* Alternative data type retrievals for Dno */
					// dno = rs.getInt("dno");
					// dno = Integer.parseInt(rs.getString("dno"));
					salary = rs.getString("salary");
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
				} // End while(rs.next())

				// Always close the recordset and connection.
				rs.close();
				conn.close();
				System.out.println("Success!!");
			} 
			catch(SQLException ex) {
				System.out.println("Error in connection: " + ex.getMessage());
			}
		}

	/*
	 *
	 */
	static void newln() {
		System.out.println();
	}
}