package com.kholodkov.custom_view_framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */

//todo: realize old session clearing functionality
//todo: realise session listeners functionality
//todo: realize storage session in cookies
//todo: rewrite product cart to this session implementation

public class CustomHttpSessionOnClientRepository {

    public static CustomHttpSession getSession(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }

    public static void saveSession(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException();
    }
}


