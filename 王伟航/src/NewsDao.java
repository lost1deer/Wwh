
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsDao {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/news1";
    private static String username = "root";
    private static String password = "root";
    private static Connection connection1 = null;
    private static PreparedStatement as = null;
    private static Statement stmt;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection1 = DriverManager.getConnection(url, username, password);
        return connection1;
    }

    public void closeConnection() throws SQLException {
        if (connection1 != null)
            connection1.close();
        if (as != null)
            as.close();
    }

    public void saveUser(News news) throws SQLException {
        try {
            connection1 = getConnection();
            String sql1 = "insert into news values(?,?,?,?)";
            as = connection1.prepareStatement(sql1);
            as.setString(1, news.getId());
            as.setString(2, news.getStyle());
            as.setString(3, news.getContent());
            as.setString(4, news.getData());
            as.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public News findById(String id) throws SQLException {
        ResultSet rst = null;
        News news = new News();
        try {
            connection1 = getConnection();
            System.out.println("开始读取数据");
            String sql = "select * from news where id='" + id + "'";
            as = connection1.prepareStatement(sql);
            rst = as.executeQuery(sql);
            while (rst.next()) {
                System.out.println(rst.getString(1) + "\t" + rst.getString(2) + "\t" + rst.getString(3) + "\t" + rst.getString(4));
                news.setId(rst.getString(1));
                news.setStyle(rst.getString(2));
                news.setContent(rst.getString(3));
                news.setData(rst.getString(4));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return news;
    }



    public void deleteById(String id) throws SQLException {
        ResultSet rst = null;
        News news = new News();
        try {
            Connection con=getConnection();
           // connection1 = getConnection();
            System.out.println("开始读取数据哈哈哈");
            //System.out.println(id);
            //String sql = "delete from news where id='id'";
            String sql = "DELETE  from news where id=?" ;

            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,id);
            ps.execute();
            if(ps.executeUpdate()>0){
            System.out.println("删除成功");
              }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }


    public void updateById(String id,String style,String content,String data) throws SQLException {
        ResultSet rst = null;
        try {

            Connection con=getConnection();
            System.out.println("开始读取数据哈");
            String sql = "UPDATE `news` SET `style`=?,`content`=?,`data`=? WHERE `id` = "+id;
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,style);
            ps.setString(2, content);
            ps.setString(3, data);

            ps.execute();
            if(ps.executeUpdate()>0){
                System.out.println("修改成功");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

    }



}