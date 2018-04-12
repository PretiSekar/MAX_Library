<%-- 
    Document   : fines
    Created on : 10 Oct, 2016, 12:14:08 AM
    Author     : Preethi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fines Information</title>
    </head>
    <body>
        <h2>Enter the details to know the fine amount</h2>
        <form action="servlet2" method="get">
            <table>
                <tr>
                    <td>Borrower ID:</td>
                    <td><input type="text" name="bid" id="bid" value="" size="50" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <select name="fine" onchange="submit();"> 
                            <option selected="selected" value="">Select answer</option> 
                            <option value="paid">Paid</option> 
                            <option value="unpaid">Unpaid</option> 
                            <option value="both">Both</option> 
                        </select> 
                    </td>
                </tr>
            </table>
            <br/>
            <input type="reset" name="reset" id="reset" value="Refresh" /> 
            <input type="submit" name="submit" value="View Fines"/>
        </form>
        <br/>
        <a href="newjsp1.jsp">Return to Main Page</a>
    </body>
</html>
