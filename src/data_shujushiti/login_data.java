package data_shujushiti;

import java.util.ArrayList;
import java.util.List;

public class login_data {
	private  static String pass="";
	private  static String user="";
	private  static String pass_dao="";
	private  static String user_dao="";
	//用户输入的变量的构造方法
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		login_data.pass = pass;
	}
	public static String getUser() {
		return user;
	}
	public  static void setUser(String user) {
		login_data.user = user;
	}
	
//数据库读取的数据的构造方法
	public static String getPass_dao() {
		return pass_dao;
	}
	public static void setPass_dao(String pass_dao) {
		login_data.pass_dao = pass_dao;
	}
	public static String getUser_dao() {
		return user_dao;
	}
	public static void setUser_dao(String user_dao) {
		login_data.user_dao = user_dao;
	}		
}
