package com.namesfound.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * @author marcel-serra.ribeiro on 18/07/2015.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PrototypesSpringContextInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    servletContext.setInitParameter("contextConfigLocation", "com.namesfound.config");
    WebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
    servletContext.addListener(new ContextLoaderListener(rootAppContext));
  }
}
