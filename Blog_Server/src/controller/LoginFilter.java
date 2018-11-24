package controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * ����Ȩ�޿��ƵĹ�����
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns= {"*.jsp","*.s"})
//��Ҫ���ص���Դ
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;//����ת��
		/**
		 * ʵ���ų�Ȩ�޷��ʿ��Ƶ���Դ
		 */
		//��ȡ��ǰ������Դ��
		String path = httpServletRequest.getServletPath(); //���ط��ʵ���Դ·��
		//�ж���Դ���Ƿ���Ҫ������
		if(path.endsWith("user.s") || path.endsWith("login.jsp")) {
			//ֱ�ӷ���
			chain.doFilter(request, response);
			return;
		}
		
		
		if(httpServletRequest.getSession().getAttribute("loginedUser") != null) {
			//�Ѿ���¼
			//����ҵ�����ִ�й�������doFilter
			chain.doFilter(request, response);
		}else {
			//δ��¼����ת��¼ҳ
			request.setAttribute("msg","���ȵ�¼ϵͳ��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
