package dao_shujufangwenceng;

import java.sql.ResultSet;
import java.sql.SQLException;

import util_gongju.JDBC;
import data_shujushiti.login_data;//��������ʵ����İ�

//���ݷ��ʲ㣬��ȡ���ݿ��е�����
public class login_dao {
	static String sql = null;  		//����sql�ַ���
    static JDBC db1 = null;  		//����JDBC��Ŀն���
    static ResultSet ret = null;  	//�������������
    
    //5.dao���ȡ���ݿ��е��û�������������ݹ�service��ʹ��
	public static void get_login_data(){
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
}
