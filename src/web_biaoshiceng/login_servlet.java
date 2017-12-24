package web_biaoshiceng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_shujushiti.login_data;
import service_yewuceng.login_service; //����ҵ���߼���İ�
/*
 * web��--------����servlet
 * ���������doget()������dopost()����
 * 
 * */

@WebServlet(description = "ʵ�ֵ�¼��servlet", urlPatterns = { "/login" })
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	login_data lgd=new login_data();//��������ʵ�����ʵ��
    public login_servlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("����get�����Ѿ�������");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//2.���յ���post����ʼִ��dopost����
		System.out.println("����post�����Ѿ�������");
		String tempus=new String(request.getParameter("user").getBytes("iso8859-1"),"utf-8");
		String tempps=new String(request.getParameter("pass").getBytes("iso8859-1"),"utf-8");
		lgd.setPass(tempps);
		lgd.setUser(tempus);
		//3.����service���login()����
        if(login_service.login()!=null){
        	//System.out.println("��¼�ɹ�");
        	response.sendRedirect("login_success.jsp");
        }
        else{
        	//System.out.println("��¼ʧ��");
        	response.sendRedirect("login_err.jsp");
        }
	}

}
