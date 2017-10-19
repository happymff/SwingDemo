/**
 * Created by mff on 2017/10/19.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DB {

    private static final String URL = "jdbc:mysql://192.168.10.116/database1";
    //数据库路径：服务器所在的计算机为localhost:1433;
    //数据库名称：UserInfo
    private static final String UserName = "root";    //用户名称
    private static final String PassWord = "1234";  //用户密码
    private static Connection conn = null;

    // 驱动程序名
    //public static String driver = "com.mysql.jdbc.Driver";
//    // URL指向要访问的数据库名students
//    String url = "jdbc:mysql://192.168.10.116/database1";
//    // MySQL配置时的用户名
//    String user = "root";
//    // MySQL配置时的密码
//    String password = "1234";
    // 加载驱动程序
//            Class.forName(driver);
//    // 连接数据库
//    Connection conn = DriverManager.getConnection(url, user, password);
    public static Connection getConnection(){
        try {
//            // 加载驱动程序
           // Class.forName(driver);
//            // 连接数据库
//            Connection conn = DriverManager.getConnection(url, user, password);
            Class.forName("com.mysql.jdbc.Driver");  //加载驱动程序
            conn = DriverManager.getConnection(URL, UserName, PassWord);    //创建数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
