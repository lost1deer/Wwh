<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>修改</title>
</head>

<body>
<% String str=request.getParameter("id");%>
<form action="Update" method="get">
    <table border="1" class="t1">
        <tr>
            <td colspan="2"><h1>修改新闻信息</h1></td>
        </tr>
        <tr>
            <td>新闻编号:</td>
            <td> <%=str %>
            <input  type="text" name="id"  style="display: none"  value="<%=str %>">
            </td>
        </tr>
        <tr>
            <td>新闻种类:</td>
            <td><input  type="text" name="style" ></td>
        </tr>

        <tr>
            <td>新闻内容:</td>
            <td><input  type="text" name="content" ></td>
        </tr>
        <tr>
            <td>新闻时间:</td>
            <td><input  type="text" name="data" ></td>
        </tr>
        <tr>
            <td >
                <input  type="submit" value="提交"/>
            </td>
            <td>
            <input type="button" onclick="window.location.href='PageServlet?flag=1'" value="返回"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
