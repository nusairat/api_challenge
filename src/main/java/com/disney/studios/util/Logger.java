package com.disney.studios.util;

import org.slf4j.LoggerFactory;

public interface Logger {

  default public org.slf4j.Logger logger() {
        return LoggerFactory.getLogger(getClass());
    }

    default public void debug(String message) {
        logger().debug(message);
    }

    default public void info(String message) {
        logger().info(message);
    }

    default public void error(String message) {
        logger().error(message);
    }

    default public void error(String message, Throwable t) {
        logger().error(message, t);
    }
}