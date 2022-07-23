package com.itheima.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //接收拦截信息
        HttpServletRequest req = (HttpServletRequest)request; //判断访问资源路径是否和登入相关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","register.jsp","/registerServlet","/checkCodeServlet"};
        //获取当前访问资源路径
        String url = req.getRequestURL().toString();
        for (String u :urls){
            if (url.contains(u)){
                //找到了放行
                chain.doFilter(request, response);
                return;
            }
        }


        //判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            chain.doFilter(request, response);
        }else {
            request.setAttribute("login_msg","没有这个用户名或者密码混子");
            //跳转到login。jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
