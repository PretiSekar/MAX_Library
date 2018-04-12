<%-- 
    Document   : finepayment
    Created on : 10 Oct, 2016, 12:03:45 AM
    Author     : Preethi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fine Payment</title>
    </head>
    <body>
        <h2>Enter the details to record a fine payment</h2>
        <form action="servlet5" method="get">
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
            <p>* mandatory field</p>
            <input type="reset" name="reset" id="reset" value="Refresh" /> 
            <input type="submit" name="Paid" value="Paid"/>
        </form>
        <br/>
        <a href="newjsp1.jsp">Return to Main Page</a>
    </body>
</html>
