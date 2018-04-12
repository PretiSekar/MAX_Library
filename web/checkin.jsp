<%-- 
    Document   : checkin
    Created on : 9 Oct, 2016, 11:41:54 PM
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
        <h2>Enter the details to check in a book</h2>
        <form action="servlet4" method="get">
            <table>
                <tr>
                    <td>ISBN*:</td>
                    <td><input type="text" name="isbn" id="isbn" value="" size="50" maxlength="50" /></td>
                </tr>
                <tr>
                    <td>Borrower ID*:</td>
                    <td><input type="text" name="bid" id="bid" value="" size="50" maxlength="50" /></td>
                </tr>
            </table>
            <p>* the field is mandatory</p>
            <input type="reset" name="reset" id="reset" value="Refresh" /> 
            <input type="submit" name="submit"/>
        </form>
        <br/>
        <a href="newjsp1.jsp">Return to Main Page</a>
    </body>
</html>
