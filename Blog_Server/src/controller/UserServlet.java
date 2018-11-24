package controller;

import java.io.IOException;

import javax.management.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yc.bean.User;
import com.yc.biz.BizException;
import com.yc.biz.UserBiz;
import com.yc.dao.BeanUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user.s")

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UserBiz uBiz = new UserBiz();
	
    public UserServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("name"+request.getParameter("name"));
		response.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		if("login".equals(op)) {
			login(request,response);
		}else if("query".equals(op)){
			query(request,response);
		}else if("add".equals(op)) {
			add(request,response);
		}else if("find".equals(op)) {
			find(request,response);
		}else if("save".equals(op)) {
			save(request,response);
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setCharacterEncoding("utf-8");
		User user = BeanUtils.asBean(request, User.class);
		String msg;
		try {
			uBiz.save(user);
			msg = "�û���Ϣ����ɹ�:";
		}catch(BizException e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		response.getWriter().append(msg);
		
	}

	private void find(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		User user = uBiz.findById(id);
		//��user���ظ�ҳ��
		String userString = JSON.toJSONString(user);
		response.getWriter().append(userString);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
			
			//����ҳ�洫�صĲ��������������ص�user������
			
			User user = BeanUtils.asBean(request, User.class);
			//����UserBiz.add���������û���ӵ����ݿ�
			try {
				uBiz.add(user);
			}catch(BizException e) {
				e.printStackTrace();
				request.setAttribute("msg", e.getMessage());
			}finally {
				//����ɹ�����ת���û���ѯ����
				//���ʧ��Ҳ��ת���û���ѯ����
				query(request, response);
			}
	}

	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		User user = BeanUtils.asBean(request, User.class);
		request.setAttribute("userList", uBiz.find(user));
		request.getRequestDispatcher("manage-user.jsp").forward(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//���ղ���
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		//Map<String, String> user = uBiz.login(username, userpwd);
		User user = null;
		
		try {
			user = uBiz.login(username, userpwd);
		}catch (BizException e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			//ʧ��
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if(user == null ) {
			request.setAttribute("msg", "�û��������������");
			//ʧ��
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			//���û���Ϣ���浽�Ự��
			request.getSession().setAttribute("loginedUser", user);
			//�ɹ�
			response.sendRedirect("index.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
