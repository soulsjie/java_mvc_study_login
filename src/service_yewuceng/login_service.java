package service_yewuceng;

import java.util.ArrayList;
import java.util.List;

import dao_shujufangwenceng.login_dao;//�������ݴ����ĵ�¼����
import data_shujushiti.login_data;//��������ʵ����İ�

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
	//ɾ���û�
	public static boolean delete(){
		return login_dao.delete();
	}
	//����û�
	public static boolean adduser(){
		return login_dao.adduser();
	}	
	//��ʾ�û���Ϣ
	public static void show(){
		userid = (List) login_dao.ShowInfo().get("userid");
		username = (List) login_dao.ShowInfo().get("username");
		userpass = (List) login_dao.ShowInfo().get("userpass");	
	}	

}
