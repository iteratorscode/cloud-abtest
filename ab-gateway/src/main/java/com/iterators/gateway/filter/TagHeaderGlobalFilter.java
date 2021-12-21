package com.iterators.gateway.filter;

import com.iterators.gateway.config.TagHeaderConfiguration;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * TagHeaderGlobalFilter
 *
 * @author iterators
 * @since 2021/12/19
 */
@AllArgsConstructor
@Component
public class TagHeaderGlobalFilter implements GlobalFilter {

    public static final String REQUEST_HEADER_TAG_ATTR = "tag";

    private final TagHeaderConfiguration tagHeaderConfiguration;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest().mutate()
                .headers(httpHeaders -> httpHeaders.add("tag", tagHeaderConfiguration.getTagHeaderProperties().getValue()))
                .build();
        return chain.filter(exchange.mutate().request(request).build());
    }
}
