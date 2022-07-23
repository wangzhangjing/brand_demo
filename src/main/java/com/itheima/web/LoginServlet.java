package com.itheima.web;


import com.itheima.pojo.User;
import com.itheima.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//调用service查询
        User user = service.longin(username, password);

        //获取复选数据框
        String remeber = request.getParameter("remeber");

        //判断
        if(user !=null){
            //登入成功
            //判断用户是否勾选记住我
            if ("1".equals(remeber)){
                //勾选了发送cookie
                //创建对象
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                //设置存活时间
                //7day
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                //发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }



            //跳转到查询所有页面
            //将登入成功页面存储到session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);

            //动态地址
            String dtym = request.getContextPath();
            response.sendRedirect(dtym+"/selectAllServlet");
        }else {
            //登入失败
            //存储错误信息到requst
            request.setAttribute("login_msg","没有这个用户名或者密码混子");
            //跳转到login。jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
