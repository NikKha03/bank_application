<%@ page import="java.util.Map" %>
<%@ page import="org.example.servlets.model.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>SignUp</title>
</head>
<body>
<%
    Map<String, Account> accounts = (Map<String, Account>) request.getAttribute("accounts");
%>
    <h2>Все пользователи:</h2>
    <table>
        <tr>
            <th>Account name</th>
            <th>Balance</th>
        </tr>
        <%
            for (var account : accounts.entrySet()) {
        %>
        <tr>
            <td><%=account.getValue().getName()%></td>
            <td><%=account.getValue().getBalance()%></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>