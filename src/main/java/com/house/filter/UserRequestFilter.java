package com.house.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserRequestFilter implements Filter {
    @Override
    public void destroy() {
    }
    
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 转换类型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //获取请求地址
        String requestURI = request.getRequestURI();
        String requestPath = requestURI.substring(requestURI.lastIndexOf('/') + 1);
        //是否是登陆页面,注册页面,登陆请求,注册请求
        if (requestPath.equals("login.jsp") ||
                requestPath.equals("regs.jsp") ||
                requestPath.equals("checkUser") ||
                requestPath.equals("registerUser")||
                requestPath.equals("goList")||
                requestPath.equals("detailHouse")||
                requestPath.equals("logout")||
                requestPath.equals("getAllStreetById")||
                requestPath.equals("loginUser")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            Object loginInfo = session.getAttribute("loginInfo");
            if (loginInfo == null) {
                response.sendRedirect("login.jsp");
            } else {
                chain.doFilter(req, resp);
            }
        }
    }
    
    @Override
    public void init(FilterConfig config) throws ServletException {
    
    }
    
}
