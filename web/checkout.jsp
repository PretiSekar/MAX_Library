<%-- 
    Document   : newjsp2
    Created on : 2 Oct, 2016, 1:43:07 PM
    Author     : Preethi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Page</title>
    </head>
    <body>
        <h2>Enter the details to check out a book</h2>
        <form action="servlet1" method="get">
            <table>
                <tr>
                    <td>ISBN*:</td>
                    <td><input type="text" name="isbn" id="isbn" value="" size="50" maxlength="20" /></td>
                </tr>
                <tr>
                    <td>Borrower ID*:</td>
                    <td><input type="text" name="bid" id="bid" value="" size="50" maxlength="20" /></td>
                </tr>
            </table>
            <p>* represents mandatory fields</p>
            <input type="reset" name="reset" id="reset" value="Refresh" /> 
            <input type="submit" name="submit"/>
        </form>
        <br/>
        <a href="newjsp1.jsp">Return to Main Page</a>
    </body>
</html>
