package org.example.msa.springboot.configuration;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
  static final String h2DbWebConsoleContext = "/console/*";

  @Bean
  ServletRegistrationBean h2servletRegistration() {
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebdavServlet());
    servletRegistrationBean.addUrlMappings(h2DbWebConsoleContext);
    return servletRegistrationBean;
  }
}
