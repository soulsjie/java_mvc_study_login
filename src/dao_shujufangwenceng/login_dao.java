package dao_shujufangwenceng;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util_gongju.JDBC;
import data_shujushiti.login_data;//��������ʵ����İ�
import data_shujushiti.UserInfo;
//���ݷ��ʲ㣬��ȡ���ݿ��е�����
public class login_dao {
	static String sql = null;  	//����sql�ַ���
    static JDBC db1 = null;  		//����JDBC��Ŀն���
    static ResultSet ret = null;  	//�������������
    
	public static void login(){
		sql = "select *from login_info where username='"+login_data.getUser()+"'";	//SQL���  
        db1 = new JDBC(sql);		//����jdbc����  
        try {  
            ret = db1.pst.executeQuery();	//ִ����䣬�õ������  
            if(ret==null){
            	System.out.println("�û��������ڣ�");
            }
            while (ret.next()) {  
            	login_data.setUser_dao(ret.getString(2)); //���û��������뱣�浽ȫ�ֱ���
            	login_data.setPass_dao(ret.getString(3));
            }	//��ʾ����  
            ret.close();  
            db1.close();//�ر�����  
        } catch (SQLException e) {  
            e.printStackTrace();   
        }  
	}
	//ɾ���û�
	public static boolean delete(){
		sql="delete from login_info where username='haha';";
		db1=new JDBC(sql);
		try {
			return db1.pst.executeUpdate()>0;//executeUpdateִ��sql��䷵��ֵ����0��ʾ����ɾ���ɹ�
			
		} catch (Exception e) {
			e.printStackTrace();  
		}
		return false;
	}
	//����û�
		public static boolean adduser(){
			sql="insert into login_info (username,password) values ('haha','����')";
			db1=new JDBC(sql);
			try {
				return db1.pst.executeUpdate()>0;//executeUpdateִ��sql��䷵��ֵ����0��ʾ�������ݳɹ�
			} catch (Exception e) {
				e.printStackTrace();  
			}
			return false;
		}
	//��ѯ�����û���Ϣ
		public static Map ShowInfo(){
			 List USid=new ArrayList();	//����û�id
			 List USname=new ArrayList();//����û��û���
			 List USpass=new ArrayList();//����û�����
			sql = "select *from login_info";	//SQL���  
	        db1 = new JDBC(sql);				//����jdbc����  
	        try {  
	            ret = db1.pst.executeQuery();	//ִ����䣬�õ������  
	            if(ret==null){
	            	System.out.println("�û��������ڣ�");
	            }
	            while (ret.next()) {  //�����ݴ������Ӧ��list
	            	USid.add(ret.getString(1));
	            	USname.add(ret.getString(2));
	            	USpass.add(ret.getString(3));
	            }
	            ret.close();  
	            db1.close();//�ر�����  
	           //��listѹ��map
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
