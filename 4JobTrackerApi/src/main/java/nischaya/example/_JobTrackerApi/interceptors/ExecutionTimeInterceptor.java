package nischaya.example._JobTrackerApi.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ExecutionTimeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {

        request.setAttribute("startTime",System.currentTimeMillis());

        if(handler instanceof HandlerMethod method){
            System.out.println("Controller : " +method.getBeanType().getName()); // We get to know which controlelr has called and takes how much time
            System.out.println("Controller method : " +method.getMethod().getName());
        }

        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex)throws Exception{

        Long duration = System.currentTimeMillis() - (Long)request.getAttribute("startTime")  ;
        System.out.println("Time taken by controller is : " +duration);
    }
}
