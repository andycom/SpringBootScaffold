package com.fancv.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebFilter(filterName = "user-fliter", urlPatterns = {"/page/*"})
@Order(1)
public class UserFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----user-fliter过滤器初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        // 对request和response进行一些预处理
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> result = servletRequest.getParameterMap();
        HttpServletRequest a = (HttpServletRequest) servletRequest;
        String Url = a.getRequestURI();
        System.out.println("url: " + Url);


        String Url2 = ((HttpServletRequest) servletRequest).getRequestURL().toString();
        System.out.println("url: " + Url2);

        result.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + Arrays.toString(value));
        });

        System.out.println("FilterDemo01执行前！！！");
        filterChain.doFilter(servletRequest, servletResponse); // 让目标资源执行，放行
        System.out.println("FilterDemo01执行后！！！");
    }

    @Override
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }
}
