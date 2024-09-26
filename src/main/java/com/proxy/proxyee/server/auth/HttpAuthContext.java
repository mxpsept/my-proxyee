package com.proxy.proxyee.server.auth;

import com.proxy.proxyee.server.auth.model.HttpToken;
import com.proxy.proxyee.server.context.HttpContext;
import io.netty.channel.Channel;

/**
 * @Author LiWei
 * @Description
 * @Date 2021/8/3 11:37
 */
public class HttpAuthContext {

    private static final String AUTH_KEY = "http_auth";

    public static HttpToken getToken(Channel clientChanel) {
        return HttpContext.get(clientChanel, AUTH_KEY);
    }

    public static void setToken(Channel clientChanel, HttpToken httpToken) {
        HttpContext.set(clientChanel, AUTH_KEY, httpToken);
    }
}
