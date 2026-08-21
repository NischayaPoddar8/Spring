package nischaya.example.InterceptorsDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) // handler has all info related to controller and is called before controller layer
            throws Exception {
        System.out.println("Incoming Request -------------------------");
        System.out.println("HTTP METHOD: " +request.getMethod());
        System.out.println("Request URI: " +request.getRequestURI());
        System.out.println("Request Parameters: " +request.getQueryString()); // req body ke parameters
        System.out.println("Client IP : " +request.getRemoteAddr());
        System.out.println("Token Header : " +request.getHeader("token"));

        if(handler instanceof HandlerMethod method){
            System.out.println("Controller : " +method.getBeanType().getName());
            System.out.println("Controller method : " +method.getMethod().getName());
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                 @Nullable Exception ex)
            throws Exception {
        System.out.println("Response Status : " +response.getStatus());
//        System.out.println("After completion called");
          return;
    }
}
