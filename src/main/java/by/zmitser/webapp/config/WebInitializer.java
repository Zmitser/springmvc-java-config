package by.zmitser.webapp.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {


//        <!-- Spring MVC -->
//        <listener>
//        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//        </listener>
//        <servlet>
//        <servlet-name>mvc-dispatcher</servlet-name>
//        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//        <init-param>
//        <param-name>contextConfigLocation</param-name>
//        <param-value>/WEB-INF/spring/dispatcher-servlet.xml</param-value>
//        </init-param>
//        <load-on-startup>1</load-on-startup>
//        </servlet>
//        <servlet-mapping>
//        <servlet-name>dispatcher</servlet-name>
//        <url-pattern>/</url-pattern>
//        </servlet-mapping>

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);

        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
