package com.proxy.proxyee.config;

import com.proxy.proxyee.server.HttpProxyServer;
import com.proxy.proxyee.server.HttpProxyServerConfig;
import com.proxy.proxyee.server.accept.HttpProxyAcceptHandler;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.internal.PlatformDependent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NettyProxyServerConfig {


    @Bean
    public void startProxyServer() {
        System.out.println("start proxy server");
        int port = 9090;
        HttpProxyServerConfig httpProxyServerConfig = new HttpProxyServerConfig();
        httpProxyServerConfig.setHttpProxyAcceptHandler(new HttpProxyAcceptHandler() {

            @Override
            public boolean onAccept(HttpRequest request, Channel clientChannel) {
                return true;
            }

            @Override
            public void onClose(Channel clientChannel) {
                log.info("内存使用情况： 已用内存 {}， 最大内存 {} ", PlatformDependent.usedDirectMemory(), PlatformDependent.maxDirectMemory());
            }
        });
        httpProxyServerConfig.setHandleSsl(true);
        new HttpProxyServer().serverConfig(httpProxyServerConfig)
                .startAsync(port);
    }
}
