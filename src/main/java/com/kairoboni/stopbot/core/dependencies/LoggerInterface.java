package com.kairoboni.stopbot.core.dependencies;

public interface LoggerInterface {
    void info(String message, Object... context);
    void debug(String message, Object... context);
    void warn(String message, Object... context);
    void error(String message, Throwable th, Object... context);
}
