import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addnews extends HttpServlet{

    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
        resp.setContentType("text/html;charset=uft-8");
        String id=req.getParameter("id");
        String style=req.getParameter("style");
        String content=req.getParameter("content");
        String data=req.getParameter("data");
        NewsDao nDao=new NewsDao();
        News news = null;
        try {
            news = nDao.findById(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(news.getId());
        System.out.println("判断Id是否存在");
        if(news.equals(news.getId())){
            String msgt=id+"该id已经使用！请重新输入！";
            req.setAttribute("msgt", msgt);
            req.getRequestDispatcher("news.jsp").forward(req, resp);
        }else{
            System.out.println("检验数据库没有该id，存入id信息！");
            News news1=new News();
            news1.setId(id);
            news1.setStyle(style);
            news1.setContent(content);
            news1.setData(data);
            try {
                nDao.saveUser(news1);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String msgt=id+"号新闻添加成功！";
            req.setAttribute("msgt", msgt);
            req.getRequestDispatcher("newsinformation.jsp").forward(req, resp);
        }
    }

    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException{
        doGet(req, resp);
    }
}