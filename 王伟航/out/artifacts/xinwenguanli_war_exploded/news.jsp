<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新闻添加</title>
</head>
<body>
<form action="addnews" method="get">
    <table border="1" cellspacing="0" >
        <tr>
            <td>新闻编号：</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>新闻种类：</td>
            <td><input type="text" name="style"></td>
        </tr>
        <tr>
            <td>新闻内容：</td>
            <td><input type="text" name="content"></td>
        </tr>
        <tr>
            <td>新闻时间：</td>
            <td><input type="text" name="data"></td>
        </tr>
        <tr>
            <td></td>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
            <td><a href="PageServlet?flag=1">查看新闻</a></td>
        </tr>
    </table>
</form>
</body>
</html>
