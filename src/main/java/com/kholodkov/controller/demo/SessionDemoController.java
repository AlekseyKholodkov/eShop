package com.kholodkov.controller.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class SessionDemoController extends HttpServlet {
    public static final String SESSION_COUNTER_NAME = "sessionCounter";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        AtomicInteger counter = (AtomicInteger)session.getAttribute(SESSION_COUNTER_NAME);
        if (counter == null) {
            counter = new AtomicInteger(1);
            session.setAttribute(SESSION_COUNTER_NAME, counter);
        } else {
            counter.getAndIncrement();
            session.setAttribute(SESSION_COUNTER_NAME, counter);
        }
        response.getWriter().write("You visit this page: " + counter + " time");
    }
}
