package org.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppLogger {

    private static final Logger logger = Logger.getLogger(AppLogger.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logException(Exception e) {
        logger.severe("Exception occurred: " + e.getMessage());
        e.printStackTrace();
    }

    public static void logExecutionTime(String message, long executionTime) {
        logger.info(message + " - Execution time: " + executionTime + " milliseconds");
    }
}
