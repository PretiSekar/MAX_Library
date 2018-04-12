<%-- 
    Document   : booksoverdue
    Created on : 10 Oct, 2016, 12:14:22 AM
    Author     : Preethi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Enter the borroewer's ID to view the books overdues</h2>
        <form action="servlet3" method="get">
            <table>
                <tr>
                    <td>Borrower ID:</td>
                    <td><input type="text" name="bid" id="bid" value="" size="50" maxlength="10" /></td>
                </tr>
            </table>
            <input type="reset" name="reset" id="reset" value="Refresh" /> 
            <input type="submit" name="submit" value="Find Books Overdue"/>
        </form>
        <br/>
        <a href="newjsp1.jsp">Return to Main Page</a>
    </body>
</html>
