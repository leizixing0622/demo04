<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
<style type="text/css">
    th {
        color: #FFF;
        background-color: #CCC;
    }
</style>
</head>
<body>
    <table width="100%" border="1" style="border-collapse:collapse;">
        <tr>
            <th scope="col">名称</th>
            <th scope="col">价格</th>
            <th scope="col">状态</th>
            <th scope="col">地址</th>
        </tr>
        <c:forEach items="${houses}" varStatus="i" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.status}</td>
                <td>${item.address}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
