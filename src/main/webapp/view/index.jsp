<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>SignUp</title>
</head>
<body>
<h2>Все пользователи:</h2>
<table>
    <tr>
        <th>Account name</th>
        <th>Balance</th>
    </tr>
    <c:forEach items="${requestScope.accounts}" var="account">
        <tr>
            <td>${account.name}</td>
            <td>${account.balance}</td>
        </tr>
    </c:forEach>
</table>
<hr/>
<h2>Создание нового пользователя</h2>
<form method="post">
    <input type="text" name="name" placeholder="Account name" minlength="5" maxlength="20"><br/>
    <input type="password" name="password" placeholder="Password" minlength="5"><br/>
    <input type="number" name="balance" placeholder="Balance" min="0" step="0.01"><br/>
    <input type="submit" value="Create"><br/>
</form>
<c:if test="${requestScope.accountExistsError}" var="true">
    <div style="color: red">Такой пользователь уже существует!</div>
</c:if>
<c:if test="${requestScope.emptyFiled}" var="true">
    <div style="color: red">Поля name и password должны быть заполнены!</div>
</c:if>
</body>
</html>