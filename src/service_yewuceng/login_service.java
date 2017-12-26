package service_yewuceng;

import java.util.ArrayList;
import java.util.List;

import dao_shujufangwenceng.login_dao;//导入数据处理层的登录方法
import data_shujushiti.login_data;//导入数据实体类的包

public class login_service {
	public static List userid=new ArrayList();
	public static List username=new ArrayList();
	public static List userpass=new ArrayList();
	public static String login(){
		login_dao.login();
		if(login_data.getPass_dao().equals(login_data.getPass())&&login_data.getUser_dao().equals(login_data.getUser())){
			return "success";
		}
		else{
			return null;
		}
	}
	//删除用户
	public static boolean delete(){
		return login_dao.delete();
	}
	//添加用户
	public static boolean adduser(){
		return login_dao.adduser();
	}	
	//显示用户信息
	public static void show(){
		userid = (List) login_dao.ShowInfo().get("userid");
		username = (List) login_dao.ShowInfo().get("username");
		userpass = (List) login_dao.ShowInfo().get("userpass");	
	}	

}
