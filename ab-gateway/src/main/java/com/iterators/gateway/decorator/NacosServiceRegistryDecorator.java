package com.iterators.gateway.decorator;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.cloud.nacos.registry.NacosServiceRegistry;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author iterators
 * @since 2021/12/21
 */
public class NacosServiceRegistryDecorator extends NacosServiceRegistry {

    private NacosServiceManager nacosServiceManager;
    private NacosServiceRegistry serviceRegistry;
    private ConfigurableApplicationContext applicationContext;
    private ConfigurableEnvironment environment;

    public NacosServiceRegistryDecorator(NacosServiceManager nacosServiceManager, NacosDiscoveryProperties nacosDiscoveryProperties, NacosServiceRegistry serviceRegistry, ConfigurableApplicationContext applicationContext) {
        super(nacosServiceManager, nacosDiscoveryProperties);
        this.serviceRegistry = serviceRegistry;
        this.applicationContext = applicationContext;
        this.environment = applicationContext.getEnvironment();
    }

    @Override
    public void register(Registration registration) {
        super.register(registration);
    }

    @Override
    public void deregister(Registration registration) {
        super.deregister(registration);
    }

    @Override
    public void close() {
        super.close();
    }

    @Override
    public void setStatus(Registration registration, String status) {
        super.setStatus(registration, status);
    }

    @Override
    public Object getStatus(Registration registration) {
        return super.getStatus(registration);
    }
}
