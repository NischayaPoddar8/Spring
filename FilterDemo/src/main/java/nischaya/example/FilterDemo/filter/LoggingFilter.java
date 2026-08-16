package nischaya.example.FilterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
import java.util.function.LongFunction;

@Component
@Order(2)
public class LoggingFilter implements Filter {

    private final HttpServletResponse httpServletResponse;

    public LoggingFilter(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String requestId = UUID.randomUUID().toString();
        httpServletResponse.setHeader("X-Request-ID",requestId); // Logs can be fetched using this random uuid

        // Request log
        System.out.println("Incoming request : "
                + httpServletRequest.getMethod() + " " // Method is post or get
                +httpServletRequest.getRequestURI()
        ); // URI gives path of req

        try{
            chain.doFilter(request,response); // Calls the next filter chain
        }

        // Finally would be called even if exception is caught or not
        finally {
            Long duration = System.currentTimeMillis()-startTime;

            // Response status
            System.out.println("Response status : " + httpServletResponse.getStatus()); // After returning back
            System.out.println("Api response time: " + duration); // To know how much time it took to respond
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
