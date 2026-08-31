package nischaya.example._JobTrackerApi.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Order(1)
public class ApiKeyValidationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String apiKey = request.getHeader("x-api-key");

        if(apiKey==null || !apiKey.equals("ADMIN@8")){
            System.out.println("Invalid api key");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType("application/json"); // To give json response error
            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Api key is missing or invalid\"\n" +
                            "}"
            );
            return; // No further filter needed to be called as api key is wrong
        }

        filterChain.doFilter(request,response);
    }
}
