package com.proxy.proxyee;

import com.proxy.proxyee.server.HttpProxyServer;
import com.proxy.proxyee.server.HttpProxyServerConfig;

/**
 * @Author LiWei
 * @Description
 * @Date 2019/9/23 17:30
 */
public class HttpProxyServerApp {
    public static void main(String[] args) {
        System.out.println("start proxy server");
        int port = 9999;
        if (args.length > 0) {
            port = Integer.valueOf(args[0]);
        }
        HttpProxyServerConfig httpProxyServerConfig = new HttpProxyServerConfig();
        httpProxyServerConfig.setHandleSsl(true);
        new HttpProxyServer().serverConfig(httpProxyServerConfig)
                .start(port);
    }
}
