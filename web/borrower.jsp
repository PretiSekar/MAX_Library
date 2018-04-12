<%-- 
    Document   : borrower
    Created on : 9 Oct, 2016, 12:17:05 AM
    Author     : Preethi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function myFunction()
            {
                
           
        var cardid=document.getElementById("B1").value;
        var ssn=document.getElementById("SSN1").value;
        var fname=document.getElementById("FN1").value;
        var lname=document.getElementById("LN1").value;
        var email=document.getElementById("E1").value;
        var address=document.getElementById("A1").value;
        var city=document.getElementById("C1").value;
        var state=document.getElementById("S1").value;
        var phone=document.getElementById("P1").value;
        document.write(cardid); 
        document.write(ssn);
        document.write(fname);
        document.write(lname);
        document.write(email);
        document.write(address);
        document.write(city);
        document.write(state);
        document.write(phone);
            }
        </script>
        
        <title>JSP Page</title>
    </head>
    <body>
        
        <h2>Enter Borrower Details</h2>
        <form action="servlet" method="get">
            <table>
                <tr>
                    <td>Borrower ID:*</td>
                    <td><input type="text" name="BorrowerID" id="B1" value="" size="50" maxlength="10" /></td>
                </tr>
                <tr>
                    <td>Social Security Number:*</td>
                    <td><input type="text" name="SSN" id="SSN1" value="" size="50" maxlength="13" /></td>
                </tr>
                <tr>
                    <td>First Name:*</td>
                    <td><input type="text" name="FirstName" id="FN1" value="" size="50" maxlength="50" /></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="LastName" id="LN1" value="" size="50" maxlength="50" /></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="text" name="Email" id="E1" value="" size="50" maxlength="50" /></td>
                </tr>       
                <tr>
                    <td>Address:*</td>
                    <td><input type="text" name="Address" id="A1" value="" size="50" maxlength="100" /></td>
                </tr>
                <tr>
                    <td>City:*</td>
                    <td><input type="text" name="City" id="C1" value="" size="50" maxlength="20" /></td>
                </tr>
                <tr>
                    <td>State:*</td>
                    <td><input type="text" name="State" id="S1" value="" size="50" maxlength="3" /></td>
                </tr>
                <tr>
                    <td>PhoneNo:</td>
                    <td><input type="text" name="PhoneNo" id="P1" value="" size="50" maxlength="15" /></td>
                </tr>
            </table>
            <br/>
            <p>* mandatory fields</p>
            <input type="reset" name="reset" id="reset" value="Refresh" /> 
            <input type="submit" name="submit"/>
            <br/>
            <br/>
            <a href="newjsp1.jsp">Return to Main Page</a>
           <%---<button type="button" onclick="myFunction()">Add Borrower</button> --%>
        </form>
    </body>
</html>
