import java.sql.SQLException;

/**
 * Created by Shinelon on 2018/8/3.
 */
public class MainTest {
    public static void main(String[] args) {
        NewsDao newsDao=new NewsDao();
//       String id="2";
//        try {
//            newsDao.deleteById(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        try{
            newsDao.updateById("4","4","4","4");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
