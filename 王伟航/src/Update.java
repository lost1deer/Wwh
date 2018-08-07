import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Update extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("test/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        NewsDao db = new NewsDao();
        try {
            db.updateById(request.getParameter("id"),request.getParameter("style"),request.getParameter("content"),request.getParameter("data"));

            System.out.println(request.getParameter("id"));
            System.out.println(request.getParameter("style"));
            System.out.println(request.getParameter("content"));
            System.out.println(request.getParameter("data"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("PageServlet?flag=1").forward(request, response);

    }


}