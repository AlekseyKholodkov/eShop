package com.kholodkov.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Spring#7-1 1:13:45
 * This class is common parent for all my oun Servlets
 * todo: how use Spring
 * todo: how use Reflection API
 * todo: how use @Inject
 * todo: what is Dependency Injection
 * todo: what is Inversion of Control
 * todo: learned interface ApplicationContext and BeanFactory
 *
 */
public class DependencyInjectorServlet extends HttpServlet{
    private static final String APP_CTX_PATH = "contextConfigLocation";

    @Override
    public void init() throws ServletException {
        String appCtxPath = this.getServletContext().getInitParameter(APP_CTX_PATH);
        System.out.println("---> Load " + APP_CTX_PATH + " -> " + appCtxPath);

        if (appCtxPath == null) {
            System.out.println("---> I need init param " + APP_CTX_PATH);
            throw new ServletException(APP_CTX_PATH + " init param == null");
        }

        try {
//            Load Application Context
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(appCtxPath);
//            Then inject from Application Context to all marked by @Inject fields
            List<Field> allFields = FieldReflector.collectUpTo(this.getClass(), DependencyInjectorServlet.class);
            List<Field> injectFields = FieldReflector.filterInject(allFields);

            for (Field field : injectFields) {
//                improve access to all fields include privet
                field.setAccessible(true);
                Inject annotation = field.getAnnotation(Inject.class);
                System.out.println("---> I find method was marked by @Inject: " + field);
                String beanName = annotation.value();
                System.out.println("---> I must instantiate and inject '" + beanName + "'");
                Object bean = applicationContext.getBean(beanName);
                System.out.println("---> Instantiation - OK: '" + beanName + "'");
                if (bean == null) {
                    throw new ServletException("There is not bean with name '" + bean + "'");
                }
                field.set(this, bean);
            }
        } catch (Exception e) {
            throw new ServletException("Cannot inject from " + APP_CTX_PATH, e);
        }
    }
}
