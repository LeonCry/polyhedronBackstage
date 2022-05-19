//package com.leon.pojo;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.security.auth.message.AuthException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Slf4j
//public class AuthInterceptor extends HandlerInterceptorAdapter {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        request.setCharacterEncoding("UTF-8");
//　　　　 if (true) {
//            return super.preHandle(request, response, handler);
//        }
//        throw new AuthException(EnumResult.PERMISSION_ERROR);
//    }
//}
