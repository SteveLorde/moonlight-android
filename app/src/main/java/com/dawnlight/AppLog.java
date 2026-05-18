package com.dawnlight;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class AppLog {
    private static final Logger LOGGER = Logger.getLogger(AppLog.class.getName());

    public static void info(String msg) {
        LOGGER.info(msg);
    }
    
    public static void warning(String msg) {
        LOGGER.warning(msg);
    }
    
    public static void severe(String msg) {
        LOGGER.severe(msg);
    }
    
    public static void setFileHandler(String fileName) throws IOException {
        LOGGER.addHandler(new FileHandler(fileName));
    }
}
