package dao_shujufangwenceng;

import java.sql.ResultSet;
import java.sql.SQLException;

import util_gongju.JDBC;
import data_shujushiti.login_data;//导入数据实体类的包

//数据访问层，读取数据库中的数据
public class login_dao {
	static String sql = null;  		//创建sql字符串
    static JDBC db1 = null;  		//创建JDBC类的空对象
    static ResultSet ret = null;  	//创建结果集对象
    
    //5.dao层读取数据库中的用户名和密码等数据供service层使用
	public static void get_login_data(){
		sql = "select *from login_info where username='"+login_data.getUser()+"'";	//SQL语句  
        db1 = new JDBC(sql);		//创建jdbc对象  
        try {  
            ret = db1.pst.executeQuery();	//执行语句，得到结果集  
            if(ret==null){
            	System.out.println("用户名不存在！");
            }
            while (ret.next()) {  
            	login_data.setUser_dao(ret.getString(2)); //将用户名和密码保存到全局变量
            	login_data.setPass_dao(ret.getString(3));
            }	//显示数据  
            ret.close();  
            db1.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}
}
