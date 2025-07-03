package com.example.demo.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
@Autowired
AutentificacionInterceptor interceptor;

public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor)
            .addPathPatterns("/**") // intercepta todas las rutas
            .excludePathPatterns("/inicioSesion/**", "/css/**", "/js/**", "/images/**"); // excluye el login y recursos estáticos
}
}