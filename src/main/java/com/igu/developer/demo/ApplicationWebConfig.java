package com.igu.developer.demo;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationWebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/graphiql").setViewName(
                "forward:/graphiql/index.html");
    }
    
   @Bean
   public ViewResolver viewResolver() {
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
 
      bean.setViewClass(JstlView.class);
       // src/main/webapp/WEB-INF/view/
      bean.setPrefix("/WEB-INF/view/");
      bean.setSuffix(".jsp");
 
      return bean;
   }    
}
