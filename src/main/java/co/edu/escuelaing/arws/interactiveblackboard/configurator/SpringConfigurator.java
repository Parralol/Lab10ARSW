package co.edu.escuelaing.arws.interactiveblackboard.configurator;

import jakarta.websocket.server.ServerEndpointConfig;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class SpringConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
        T endpoint = super.getEndpointInstance(endpointClass);
        // Use Spring's support class to inject dependencies into the WebSocket endpoint
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(endpoint);
        return endpoint;
    }
}
