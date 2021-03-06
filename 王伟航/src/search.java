import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class search extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NewsDao db = new NewsDao();
        try {

            News news = db.findById(request.getParameter("id"));
            request.setAttribute("news",news);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("search.jsp").forward(request, response);

    }


}