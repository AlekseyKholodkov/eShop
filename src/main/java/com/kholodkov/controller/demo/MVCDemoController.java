package com.kholodkov.controller.demo;

import com.kholodkov.entity.demo.DemoEntityA;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet#5-1 time 2:06:20
 */
public class MVCDemoController extends HttpServlet {
    public static final String DEMO_PAGE = "./WEB-INF/pages/demo/mvcDemoView.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        add to REQUEST attribute
        request.setAttribute("requestAttribute", new DemoEntityA());

//        add to SESSION attribute
        request.getSession().setAttribute("sessionAttribute", new DemoEntityA());

//        add to SERVLET CONTEXT attribute
        request.getServletContext().setAttribute("servletContextAttribute", new DemoEntityA());

        request.setAttribute("testContext", "request");
        request.getSession().setAttribute("testContext", "session");
        request.getServletContext().setAttribute("testContext", "servletContext");

        request.getRequestDispatcher(DEMO_PAGE).forward(request, response);
    }


}
