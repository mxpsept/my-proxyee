package com.proxy.proxyee;

import com.proxy.proxyee.server.HttpProxyServer;
import com.proxy.proxyee.server.HttpProxyServerConfig;

public class HandelSslHttpProxyServer {

    public static void main(String[] args) throws Exception {
        HttpProxyServerConfig config = new HttpProxyServerConfig();
        config.setHandleSsl(true);
        config.setMaxHeaderSize(8192 * 2);
        new HttpProxyServer()
                .serverConfig(config)
                .start(9999);
    }
}
