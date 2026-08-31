package nischaya.example._JobTrackerApi.config;

import nischaya.example._JobTrackerApi.interceptors.ExecutionTimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private ExecutionTimeInterceptor executionTimeInterceptor;

    public WebMvcConfig(ExecutionTimeInterceptor executionTimeInterceptor) {
        this.executionTimeInterceptor = executionTimeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(executionTimeInterceptor).
        addPathPatterns("/api/**"); // Any path after api
    }
}
