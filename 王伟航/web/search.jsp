<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2018/8/4
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="search" method="get">
    <table border="1" cellspacing="0">
        <tr>
            <td align="center" colspan="2">信息查找</td>
        </tr>
        <tr>
            <td>编号：</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
    <table border="1" cellspacing="0">
    <tr >
        <td>${news.id}</td>
        <td>${news.style}</td>
        <td>${news.content}</td>
        <td>${news.data}</td>
    </tr>
    </table>
</form>
</body>
</html>
