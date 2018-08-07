import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class Login extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=uft-8");
        String name = req.getParameter("name");
        String pwd = req.getParameter("password");
        HttpSession hs = req.getSession();
        hs.setAttribute("1", name);
        hs.setAttribute("2", pwd);
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.findByName(name);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (name != null && pwd != null && name.equals(user.getName()) && pwd.equals(user.getPassword())) {
            resp.sendRedirect("news.jsp");
        } else {
            String msg = "你所输入的用户名不存在或者密码不正确，请重新输入！";
            req.setAttribute("msg", msg);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}




