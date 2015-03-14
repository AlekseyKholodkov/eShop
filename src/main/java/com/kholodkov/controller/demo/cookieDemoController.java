package com.kholodkov.controller.demo;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class cookieDemoController extends HttpServlet {
    public static final String COOKIE_COUNTER = "counter";
    public static final int COOKIE_EXPIRE = 2 * 60; /*time expire in second*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookieCounterFromClient = null;
        Cookie cookieCounterToClient = new Cookie(COOKIE_COUNTER, "");
        cookieCounterToClient.setMaxAge(COOKIE_EXPIRE);
        int visitCount;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIE_COUNTER.equals(cookie.getName())) {
                    cookieCounterFromClient = cookie;
                    break;
                }
            }
        }
        if (cookieCounterFromClient == null) {
            visitCount = 1;
            cookieCounterToClient.setValue("" + visitCount);
            response.addCookie(cookieCounterToClient);
            response.getWriter().write("You visit this page first time");
        } else {
            visitCount = Integer.valueOf(cookieCounterFromClient.getValue());
            visitCount++;
            cookieCounterToClient.setValue("" + visitCount);
            response.addCookie(cookieCounterToClient);
            response.getWriter().write("You visit this page: " + visitCount + " time.");
        }
    }
}
