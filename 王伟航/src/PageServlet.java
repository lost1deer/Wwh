
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNow=1;//当前页数
        int totalrecord = 0;//总信息数

        //获取总信息数(从dao层的arraylist中)
        try {
            PageDao dao = new PageDao();
            List list =  dao.pageDao();
            totalrecord = list.size();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //设置pagesize，获取总页数,每页显示数据数(创建pagebean实例)
        int pageSize=5;
        int totalpages=new TotalPagesCal().calculateTP(pageSize,totalrecord);

        //对用户点击跳转页数进行处理
        int flag;
        flag = Integer.parseInt(request.getParameter("flag"));//获取a标签参数
        switch (flag) {
            case 1: {//首页
                pageNow = 1;
                break;
            }
            case 2: {//上一页
                pageNow = Integer.parseInt(request.getParameter("pno"))-1;
                break;
            }
            case 3: {//下一页
                pageNow = Integer.parseInt(request.getParameter("pno"))+1;
                break;
            }
            case 4: {//尾页
                pageNow = totalpages;
                break;
            }
            case 5: {//跳转到某一页
                String c1=request.getParameter("pagese");
                System.out.println(c1);
                pageNow = Integer.parseInt(c1);
                System.out.println(pageNow);
                break;
            }
            default:{System.out.println("传参有误");}
        }


        /*
        分页数据
         */
        //将pagenow的值传给dao层并获取分页信息
        try {
            PageDao dao = new PageDao();//实例化dao层对象
            ArrayList<News> pinf = dao.Paging(pageNow,pageSize);//调用paging方法传值
            request.setAttribute("pinf",pinf);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //将信息存到request
        request.setAttribute("pagenow", pageNow);
        request.setAttribute("totalrec", totalrecord);
        request.setAttribute("totalpages", totalpages);
        //跳转回前台
        request.getRequestDispatcher(request.getContextPath()+"/information.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
