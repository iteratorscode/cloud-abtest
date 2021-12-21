package com.iterators.gateway.config;

import com.iterators.gateway.properties.TagHeaderProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author iterators
 * @since 2021/12/19
 */
@Configuration
@EnableConfigurationProperties(TagHeaderProperties.class)
@AllArgsConstructor
@Data
public class TagHeaderConfiguration {

    private final TagHeaderProperties tagHeaderProperties;

}
