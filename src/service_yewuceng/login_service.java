package service_yewuceng;

import dao_shujufangwenceng.login_dao;//�������ݴ����ĵ�¼����
import data_shujushiti.login_data;//��������ʵ����İ�

public class login_service {
	public static String login(){
		//4.service�㣨ҵ���߼��㣩��֤web���û��ύ�����ݺ�dao��ȡ�������ݣ���֤�û��Ƿ��¼�ɹ��������ظ�servletһ��ֵ��servlet���ݸ�ֵ�ж��Ƿ��¼�ɹ�������Ӧ�Ķ�̬ҳ�����ɺ�ҳ�����ת
		login_dao.get_login_data();//ִ��dao���get_login_data()����,�����ݿ��ȡ�����ݴ�ŵ�����ʵ����
		//��֤web������ݺ�dao������ݣ�ʵ�ֵ�¼��ҵ��
		if(login_data.getPass_dao().equals(login_data.getPass())&&login_data.getUser_dao().equals(login_data.getUser())){
			return "success";
		}
		else{
			return null;
		}
	}
}
