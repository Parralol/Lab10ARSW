package co.edu.escuelaing.arws.interactiveblackboard.configurator;

import jakarta.websocket.server.ServerEndpointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringConfigurator extends ServerEndpointConfig.Configurator {

    private static volatile ApplicationContext context;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringConfigurator.context = applicationContext;
    }

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return context.getAutowireCapableBeanFactory().createBean(clazz);
    }
}