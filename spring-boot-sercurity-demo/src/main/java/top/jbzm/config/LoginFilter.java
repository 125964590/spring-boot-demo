//package top.jbzm.config;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
///**
// * @author jbzm
// * @date Create on 2018/3/7 23:28
// */
////@Order(1)
////@WebFilter(filterName = "logerFilter", urlPatterns = "/*")
//
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String username = "";
//        Object user = request.getAttribute("user");
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//
//        }else{
//
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
