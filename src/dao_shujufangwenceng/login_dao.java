package dao_shujufangwenceng;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util_gongju.JDBC;
import data_shujushiti.login_data;//导入数据实体类的包
import data_shujushiti.UserInfo;
//数据访问层，读取数据库中的数据
public class login_dao {
	static String sql = null;  	//创建sql字符串
    static JDBC db1 = null;  		//创建JDBC类的空对象
    static ResultSet ret = null;  	//创建结果集对象
    
	public static void login(){
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
	//删除用户
	public static boolean delete(){
		sql="delete from login_info where username='haha';";
		db1=new JDBC(sql);
		try {
			return db1.pst.executeUpdate()>0;//executeUpdate执行sql语句返回值大于0表示数据删除成功
			
		} catch (Exception e) {
			e.printStackTrace();  
		}
		return false;
	}
	//添加用户
		public static boolean adduser(){
			sql="insert into login_info (username,password) values ('haha','哈哈')";
			db1=new JDBC(sql);
			try {
				return db1.pst.executeUpdate()>0;//executeUpdate执行sql语句返回值大于0表示插入数据成功
			} catch (Exception e) {
				e.printStackTrace();  
			}
			return false;
		}
	//查询所有用户信息
		public static Map ShowInfo(){
			 List USid=new ArrayList();	//存放用户id
			 List USname=new ArrayList();//存放用户用户名
			 List USpass=new ArrayList();//存放用户密码
			sql = "select *from login_info";	//SQL语句  
	        db1 = new JDBC(sql);				//创建jdbc对象  
	        try {  
	            ret = db1.pst.executeQuery();	//执行语句，得到结果集  
	            if(ret==null){
	            	System.out.println("用户名不存在！");
	            }
	            while (ret.next()) {  //将数据存放至对应的list
	            	USid.add(ret.getString(1));
	            	USname.add(ret.getString(2));
	            	USpass.add(ret.getString(3));
	            }
	            ret.close();  
	            db1.close();//关闭连接  
	           //将list压入map
	            UserInfo.userinfo.put("userid",USid);
	            UserInfo.userinfo.put("username",USname);
	            UserInfo.userinfo.put("userpass",USpass);
	            return UserInfo.userinfo;
	        } catch (SQLException e) {  
	            e.printStackTrace();   
	        }
	        return null;
		}
}
