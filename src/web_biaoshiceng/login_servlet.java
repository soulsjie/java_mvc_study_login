package web_biaoshiceng;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_shujushiti.login_data;		//��������ʵ����
import service_yewuceng.login_service; //����ҵ���߼���İ�

@WebServlet(description = "ʵ�ֵ�¼��servlet", urlPatterns = { "/login" })
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	login_data lgd=new login_data();//��������ʵ�����ʵ��
    public login_servlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request,response);//�����е�get����ת���post����
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("op"));
		if((request.getParameter("op")).equals("del")){//ɾ���û���Ϣ
			System.out.println("ɾ����������ִ��");
			if(login_service.delete()){
				System.out.println("����ɾ���ɹ�");
			}
			else{
				System.out.println("����ɾ��ʧ��");
			}
		}
		else if((request.getParameter("op")).equals("add")){//����û���Ϣ
			System.out.println("����û���Ϣ�Ĳ�������ִ��");
			if(login_service.adduser()){
				System.out.println("����û��ɹ�");
			}
			else{
				System.out.println("����û�ʧ��");
			}
		}
		else if((request.getParameter("op")).equals("show")){//��ʾ�û���Ϣ
			login_service.show();
		}
		else if((request.getParameter("op")).equals("login")){//��֤�û���¼
			System.out.println("����post�����Ѿ�������");
			String tempus=new String(request.getParameter("user").getBytes("iso8859-1"),"utf-8");
			String tempps=new String(request.getParameter("pass").getBytes("iso8859-1"),"utf-8");
			lgd.setPass(tempps);
			lgd.setUser(tempus);
	        if(login_service.login()!=null){
	        	//System.out.println("��¼�ɹ�");
	        	response.sendRedirect("login_success.jsp");
	        }
	        else{
	        	//System.out.println("��¼ʧ��");
	        	response.sendRedirect("login_err.jsp");
	        }
		}
		else{
			System.out.println("ָ�����");
		}
	}

}
