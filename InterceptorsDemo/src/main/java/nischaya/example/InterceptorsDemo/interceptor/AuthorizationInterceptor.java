package nischaya.example.InterceptorsDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {

        String userRole = request.getHeader("x-user-role");

        if(userRole==null || !userRole.equals("ADMIN")){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN); // User is forbidden to perform some actions
            response.setContentType("application/json");
            response.getWriter().write(
                    "{\n" +
                    "    \"message\" : \"Forbidden to perform actions\"\n" +
                    "}"
            );
            return false;
        }
        return true;
    }
}
