<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2023/3/14
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored ="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>地铁线路</th>
        <th>地铁车次</th>

    </tr>
<c:forEach items="${list}" var="list">
   <tr> <td><input type="text" name="xianlu" value="${list.xianlu}"></td>
       <td><input type="text" name="cid" value="${list.cid}"></td></tr>
</c:forEach>
</table>
</body>
</html>
