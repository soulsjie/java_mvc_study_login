package util_gongju;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  

//myql���ݿ����ӹ�����
public class JDBC {  
    public static final String url = "jdbc:mysql://localhost:3306/mvc_study";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
    public static boolean status=false;
  
    public Connection conn = null;  //�����յ����ݿ����Ӷ���
    public PreparedStatement pst = null;  //������Ҫִ�е�sql����
  
    //�������ݿ����ӡ�����Ҫִ�е�sql��䵱������׼����
    public JDBC(String sql) { 
        try {  
            Class.forName(name);										//�������ݿ����ӵ�����
            conn = DriverManager.getConnection(url, user, password);	//�������ݿ�����
            pst = conn.prepareStatement(sql);							//׼����Ҫִ�е�sql���
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    //�ر����ݿ�����
    public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  
