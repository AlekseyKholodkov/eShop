package com.kholodkov.custom_view_framework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//todo: realize old session clearing functionality
//todo: realize session listeners functionality
//todo: rewrite product cart to this session implementation
public class CustomHttpSessionOnServerRepository {
    public static final Map<String, CustomHttpSession> sessions = new ConcurrentHashMap<>();

    public static CustomHttpSession getSession(String sessionID) {
        return getSession(sessionID, true);
    }

    public static CustomHttpSession getSession(String sessionID, boolean canCreate) {
        CustomHttpSession result = sessions.get(sessionID);
        if (result == null && canCreate) {
            result = new CustomHttpSession();
            sessions.put(sessionID, result);
        }
        return result;
    }
}
