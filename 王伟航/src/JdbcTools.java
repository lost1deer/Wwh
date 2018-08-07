import java.sql.*;

public class JdbcTools {
    private static final String URL = "jdbc:mysql://localhost:3306/news1";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    //创建连接工具
    public Connection getConnection(String user,String pass) throws ClassNotFoundException, SQLException {
        Connection con=null;
        String driver="com.mysql.jdbc.Driver";
        Class.forName(driver);
        con=DriverManager.getConnection(URL,USER,PASSWORD);
        return con;
    }

    //封装静态dosql工具
    public ResultSet doSql(Connection con, String sqlWord) throws SQLException {
        PreparedStatement st=con.prepareStatement(sqlWord);
        ResultSet re=st.executeQuery();
        return re;
    }

    //释放数据库连接工具
    public void releaseConnection(Connection conn) throws SQLException {
        if (conn != null)
            conn.close();
    }

}
