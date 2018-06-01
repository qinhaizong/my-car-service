package com.sample;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.apache.olingo.odata2.core.rest.app.ODataApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean cxfNonSpringJaxrsServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new CXFNonSpringJaxrsServlet(), "/CarService.svc/*");
        bean.addInitParameter("javax.ws.rs.Application", ODataApplication.class.getName());
        bean.addInitParameter("org.apache.olingo.odata2.service.factory", CarServiceFactory.class.getName());
        bean.setLoadOnStartup(1);
        return bean;
    }
}
