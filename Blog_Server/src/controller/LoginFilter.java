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
 * 访问权限控制的过滤器
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns= {"*.jsp","*.s"})
//我要拦截的资源
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
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;//向下转型
		/**
		 * 实现排除权限访问控制的资源
		 */
		//获取当前访问资源名
		String path = httpServletRequest.getServletPath(); //返回访问的资源路径
		//判断资源名是否需要被拦截
		if(path.endsWith("user.s") || path.endsWith("login.jsp")) {
			//直接放行
			chain.doFilter(request, response);
			return;
		}
		
		
		if(httpServletRequest.getSession().getAttribute("loginedUser") != null) {
			//已经登录
			//正常业务必须执行过滤器的doFilter
			chain.doFilter(request, response);
		}else {
			//未登录，跳转登录页
			request.setAttribute("msg","请先登录系统！");
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
