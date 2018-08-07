<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MACHENIKE
  Date: 2018/7/29
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageWork</title>
</head>
<body>
<c:set var="pagenow" value="${pagenow}" scope="request"></c:set>
<div align="center">
    <h1>
        <c:out value="当前是第${pagenow}页"></c:out>
    </h1>
    <table style="border: 1px solid">
        <c:forEach items="${pinf}" var="i">
            <tr style="border: 1px solid">
                <td style="border:1px solid">${i.id}</td>
                <td style="border: 1px solid">${i.style}</td>
                <td style="border: 1px solid">${i.content}</td>
                <td style="border: 1px solid">${i.data}</td>
                <td style="border:1px solid">
                    <a href="Delete?id=${i.id}">删除</a>
                </td>
                <td style="border:1px solid">
                    <a href="update.jsp?id=${i.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        <input type="button" onclick="window.location.href='search.jsp'" value="查询"/>
    </table>
</div>
<table align="center">
    <tr>
        <%--首页、上一页--%>
        <td>
            <c:if test="${pagenow!=1}">
        <td><a href="PageServlet?flag=1&pno=${pagenow}">首页</a></td>
        <td><a href="PageServlet?flag=2&pno=${pagenow}">上一页</a></td>
        </c:if>
        </td>
        <%--下一页、尾页--%>
        <td>
            <c:if test="${pagenow!=totalpages}">
        <td><a href="PageServlet?flag=3&pno=${pagenow}">下一页</a></td>
        <td><a href="PageServlet?flag=4&pno=${pagenow}">尾页</a></td>
        </c:if>
        </td>
    </tr>
</table>
</body>
</html>
