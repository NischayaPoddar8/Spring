package nischaya.example.FilterDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

    private final HttpServletResponse httpServletResponse;

    public AuthenticationFilter(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String token = httpServletRequest.getHeader("token");
        String apiKey = httpServletRequest.getHeader("x-api-key");

        if(token==null || !token.equals("12345")){
            System.out.println("Invalid token");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            return;
        }

        if(apiKey==null || !apiKey.equals("secret12")){
            System.out.println("Invalid API key");
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write( // Sends message to client
                    "{" +
                            "\"message\": \"Api key missing or invalid\"" +
                            "}"
            );
            return;
        }

        chain.doFilter(request,response); // Calls the next filter chain if token is valid
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
