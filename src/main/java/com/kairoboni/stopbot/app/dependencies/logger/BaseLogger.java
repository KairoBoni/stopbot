package com.kairoboni.stopbot.app.dependencies.logger;

import com.kairoboni.stopbot.core.dependencies.LoggerInterface;
import org.slf4j.LoggerFactory;

public class BaseLogger implements LoggerInterface {

    private final org.slf4j.Logger logger;

    public BaseLogger(Class<?> service) {
        this.logger = LoggerFactory.getLogger(service);
    }

    @Override
    public void info(String message, Object... context) {
        this.logger.info(this.formatMessage(message, context));
    }

    @Override
    public void debug(String message, Object... context) {
        this.logger.debug(this.formatMessage(message, context));
    }

    @Override
    public void warn(String message, Object... context) {
        this.logger.warn(this.formatMessage(message, context));
    }

    @Override
    public void error(String message, Throwable th, Object... context) {
        this.logger.error(this.formatMessage(message, context), th);
    }

    private String formatMessage(String message, Object... context) {
        return String.format(message, context);
    }
}
