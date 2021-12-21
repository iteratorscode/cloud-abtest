package com.iterators.gateway.context;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistry;
import com.iterators.gateway.decorator.NacosDiscoveryClientDecorator;
import com.iterators.gateway.decorator.NacosServiceRegistryDecorator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * DemoApplicationInitializer
 *
 * @author iterators
 * @since 2021/12/21
 */
public class NacosApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        configurableApplicationContext.getBeanFactory().addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof DiscoveryClient) {
                    return new NacosDiscoveryClientDecorator((DiscoveryClient) bean, configurableApplicationContext);
                } else if (bean instanceof NacosServiceRegistry) {
                    NacosServiceManager nacosServiceManager = configurableApplicationContext.getBean(NacosServiceManager.class);
                    NacosDiscoveryProperties nacosDiscoveryProperties = configurableApplicationContext.getBean(NacosDiscoveryProperties.class);
                    return new NacosServiceRegistryDecorator(nacosServiceManager, nacosDiscoveryProperties, (NacosServiceRegistry) bean, configurableApplicationContext);
                } else if (bean instanceof NacosDiscoveryProperties) {
                    NacosDiscoveryProperties nacosDiscoveryProperties = (NacosDiscoveryProperties) bean;
                    Map<String, String> metadata = nacosDiscoveryProperties.getMetadata();
                    metadata.put("tag", "gray");
                    return bean;
                }
                return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
            }
        });
    }
}
