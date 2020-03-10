package com.atguigu.springcloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 */
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path-route-oschinanews", r -> r.path("/news").uri("https://www.oschina.net/news"))
                .route("path-route-keylol", r -> r.path("/f234-1").uri("https://keylol.com/f234-1"))
                .build();
    }
}
