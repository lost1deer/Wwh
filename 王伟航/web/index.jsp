<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>登陆界面</title>
</head>
<body>
  <a >${msg}</a>
  <form action="login" method="get">
    <table border="1" cellspacing="0" >
      <tr>
        <td align="center" colspan="2">用户登录</td>
      </tr>
      <tr>
        <td>用户名：</td>
        <td><input type="text" name="name" ></td>
      </tr>
      <tr>
        <td>密　码：</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="submit" value="提交">
          <input type="button" onclick="window.location.href='register.jsp'" value="注册"/>
          <input type="button" onclick="window.location.href='PageServlet?flag=1'" value="vip登陆"/>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>
