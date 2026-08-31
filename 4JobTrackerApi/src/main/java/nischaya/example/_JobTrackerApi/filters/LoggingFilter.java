package nischaya.example._JobTrackerApi.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2) // Log shall be started after the user is authenticated
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        long startTime = System.currentTimeMillis();
        String requestId = UUID.randomUUID().toString();
        response.setHeader("x-request-id",requestId); // used to know which request caused what

        System.out.println("Incoming request : " +
                request.getMethod() + "\n" + "Path of incoming request : " +
                request.getRequestURI()
        ); // Tells the type and path of request -->POST/GET/...

        try{
            filterChain.doFilter(request,response);
        }
        finally {
            Long duration = System.currentTimeMillis()-startTime;
            System.out.println("Response status : " + response.getStatus());
            System.out.println("Time taken by api = " + duration);
        }
    }
}
