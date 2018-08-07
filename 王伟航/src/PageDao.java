import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PageDao {
    private static final String URL = "jdbc:mysql://localhost:3306/news1";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    JdbcTools dao = new JdbcTools();

    /*
    从数据库获取全部信息，存在ArrayList中（用于获取总信息数）
     */
    public ArrayList<News> pageDao() throws SQLException, ClassNotFoundException {
        //连接数据库并获取信息存在list中
        Connection con = dao.getConnection("root", "root");
        String sqlWord = "SELECT * from news";
        ResultSet re = dao.doSql(con, sqlWord);

        ArrayList<News> news = new ArrayList<>();
        while (re.next()) {
            News inf = new News();
            inf.setId(re.getString("id"));
            inf.setStyle(re.getString("style"));
            inf.setContent(re.getString("content"));
            inf.setData(re.getString("data"));
            news.add(inf);

        }
        dao.releaseConnection(con);
        return news;
    }

    /*
      sql分页处理
     */
    public ArrayList<News> Paging(int pn,int ps) throws SQLException, ClassNotFoundException {
        Connection con = dao.getConnection("root", "root");
        String sqlWord = "select * from news limit ?,?";
        PreparedStatement st = con.prepareStatement("select * from news limit ?,?");
        st.setInt(1,(pn-1)*5);
        st.setInt(2,ps);
        ResultSet re = st.executeQuery();

        ArrayList<News> news = new ArrayList<>();
        while (re.next()) {
            News inf = new News();
            inf.setId(re.getString("id"));
            inf.setStyle(re.getString("style"));
            inf.setContent(re.getString("content"));
            inf.setData(re.getString("data"));
            news.add(inf);
        }
        dao.releaseConnection(con);
        return news;

    }

}