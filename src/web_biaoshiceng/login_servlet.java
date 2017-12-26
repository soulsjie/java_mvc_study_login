package web_biaoshiceng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_shujushiti.login_data;		//导入数据实体类
import service_yewuceng.login_service; //导入业务逻辑层的包

@WebServlet(description = "实现登录的servlet", urlPatterns = { "/login" })
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	login_data lgd=new login_data();//创建数据实体类的实例
    public login_servlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request,response);//将所有的get请求都转变成post请求
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("op"));
		if((request.getParameter("op")).equals("del")){//删除用户信息
			System.out.println("删除操作将被执行");
			if(login_service.delete()){
				System.out.println("数据删除成功");
			}
			else{
				System.out.println("数据删除失败");
			}
		}
		else if((request.getParameter("op")).equals("add")){//添加用户信息
			System.out.println("添加用户信息的操作将被执行");
			if(login_service.adduser()){
				System.out.println("添加用户成功");
			}
			else{
				System.out.println("添加用户失败");
			}
		}
		else if((request.getParameter("op")).equals("show")){//显示用户信息
			login_service.show();
		}
		else if((request.getParameter("op")).equals("login")){//验证用户登录
			System.out.println("这是post请求已经被触发");
			String tempus=new String(request.getParameter("user").getBytes("iso8859-1"),"utf-8");
			String tempps=new String(request.getParameter("pass").getBytes("iso8859-1"),"utf-8");
			lgd.setPass(tempps);
			lgd.setUser(tempus);
	        if(login_service.login()!=null){
	        	//System.out.println("登录成功");
	        	response.sendRedirect("login_success.jsp");
	        }
	        else{
	        	//System.out.println("登录失败");
	        	response.sendRedirect("login_err.jsp");
	        }
		}
		else{
			System.out.println("指令错误");
		}
	}

}
