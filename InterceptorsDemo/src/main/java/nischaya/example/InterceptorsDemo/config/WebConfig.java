package nischaya.example.InterceptorsDemo.config;

import nischaya.example.InterceptorsDemo.interceptor.AuthenticationInterceptor;
import nischaya.example.InterceptorsDemo.interceptor.AuthorizationInterceptor;
import nischaya.example.InterceptorsDemo.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;
    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoggingInterceptor loggingInterceptor,
                     AuthenticationInterceptor authenticationInterceptor,
                     AuthorizationInterceptor authorizationInterceptor){
        this.loggingInterceptor = loggingInterceptor;
        this.authenticationInterceptor = authenticationInterceptor;
        this.authorizationInterceptor = authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){ // Only after registry interceptor works
        registry.addInterceptor(loggingInterceptor).order(3);

        registry.addInterceptor(authenticationInterceptor).order(1);

        registry.addInterceptor(authorizationInterceptor).order(2);
    }
}
