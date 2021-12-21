package com.iterators.gateway.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TagHeaderProperties
 *
 * @author iterators
 * @since 2021/12/19
 */
@ConfigurationProperties(prefix = TagHeaderProperties.PREFIX)
@Data
public class TagHeaderProperties {

    public static final String PREFIX = "tag";

    private String value;
}
