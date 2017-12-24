package web_biaoshiceng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_shujushiti.login_data;
import service_yewuceng.login_service; //导入业务逻辑层的包
/*
 * web层--------创建servlet
 * 包含请求的doget()方法和dopost()方法
 * 
 * */

@WebServlet(description = "实现登录的servlet", urlPatterns = { "/login" })
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	login_data lgd=new login_data();//创建数据实体类的实例
    public login_servlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("这是get请求已经被触发");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//2.接收到表单post请求开始执行dopost方法
		System.out.println("这是post请求已经被触发");
		String tempus=new String(request.getParameter("user").getBytes("iso8859-1"),"utf-8");
		String tempps=new String(request.getParameter("pass").getBytes("iso8859-1"),"utf-8");
		lgd.setPass(tempps);
		lgd.setUser(tempus);
		//3.调用service层的login()方法
        if(login_service.login()!=null){
        	//System.out.println("登录成功");
        	response.sendRedirect("login_success.jsp");
        }
        else{
        	//System.out.println("登录失败");
        	response.sendRedirect("login_err.jsp");
        }
	}

}
