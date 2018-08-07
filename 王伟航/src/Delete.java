import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Delete extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NewsDao db = new NewsDao();
        try {

            db.deleteById(request.getParameter("id"));
            System.out.println("id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("PageServlet?flag=1").forward(request, response);

    }


}