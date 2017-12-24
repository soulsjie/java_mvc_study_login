package service_yewuceng;

import dao_shujufangwenceng.login_dao;//导入数据处理层的登录方法
import data_shujushiti.login_data;//导入数据实体类的包

public class login_service {
	public static String login(){
		//4.service层（业务逻辑层）验证web层用户提交的数据和dao层取到的数据，验证用户是否登录成功，并返回给servlet一个值，servlet根据该值判断是否登录成功进行相应的动态页面生成和页面的跳转
		login_dao.get_login_data();//执行dao层的get_login_data()方法,将数据库读取的数据存放到数据实体类
		//验证web层的数据和dao层的数据，实现登录的业务
		if(login_data.getPass_dao().equals(login_data.getPass())&&login_data.getUser_dao().equals(login_data.getUser())){
			return "success";
		}
		else{
			return null;
		}
	}
}
