package util_gongju;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

//myql数据库连接工具类
public class JDBC {  
    public static final String url = "jdbc:mysql://localhost:3306/mvc_study";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
    public static boolean status=false;
  
    public Connection conn = null;  //创建空的数据库连接对象
    public PreparedStatement pst = null;  //创建将要执行的sql对象
  
    //创建数据库连接、并将要执行的sql语句当做参数准备好
    public JDBC(String sql) { 
        try {  
            Class.forName(name);										//申明数据库连接的类型
            conn = DriverManager.getConnection(url, user, password);	//创建数据库连接
            pst = conn.prepareStatement(sql);							//准备好要执行的sql语句
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    //关闭数据库连接
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  
