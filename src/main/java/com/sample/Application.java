package com.sample;

import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import static org.apache.olingo.odata2.api.ODataServiceFactory.FACTORY_LABEL;

/**
 * @author qinhaizong
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean odataServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new ODataServlet(), "/CarService.svc/*");
        bean.addInitParameter(FACTORY_LABEL, CarServiceFactory.class.getName());
        return bean;
    }
}
