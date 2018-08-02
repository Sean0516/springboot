package com.sean.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Sean on 2018/8/1
 *
 * @author Sean
 */
@ConfigurationProperties(prefix = "endpoints.reload")
public class ReloadEndpoint extends org.springframework.boot.actuate.endpoint.AbstractEndpoint<Map<String, Object>> implements ApplicationContextAware {

    private static final Map<String, Object> NO_CONTEXT_MESSAGE = Collections.unmodifiableMap(Collections.singletonMap("message", "No context to reload."));
    private static final Map<String, Object> RELOAD_MESSAGE = Collections.unmodifiableMap(Collections.singletonMap("message", "reloading server"));
    private ConfigurableApplicationContext context;

    public ReloadEndpoint() {
        super("reload", true, false);
    }

    @Override
    public Map<String, Object> invoke() {
        if (this.context == null) {
            return NO_CONTEXT_MESSAGE;
        } else {
            boolean var6 = false;

            Map var1;
            try {
                var6 = true;
                var1 = RELOAD_MESSAGE;
                var6 = false;
            } finally {
                if (var6) {
                    Thread thread = new Thread(() -> {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ReloadEndpoint.this.context.stop();
                        ReloadEndpoint.this.context.start();
                    });
                    thread.setContextClassLoader(getClass().getClassLoader());
                    thread.start();
                }
            }

            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ReloadEndpoint.this.context.stop();
                ReloadEndpoint.this.context.start();
            });
            thread.setContextClassLoader(getClass().getClassLoader());
            thread.start();
            return var1;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        if (context instanceof ConfigurableApplicationContext) {
            this.context = (ConfigurableApplicationContext) context;
        }
    }
}
