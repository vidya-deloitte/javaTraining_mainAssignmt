import java.io.IOException;
import java.util.logging.*;

public class LoggerFile {
    private static Logger logger;
    private static FileHandler fileHandler;

    // Initialize the logger and set up the file handler
    static {
        try {
            logger = Logger.getLogger(LoggerFile.class.getName());
            logger.setLevel(Level.ALL); // Set the default log level

            fileHandler = new FileHandler("myLogFile.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(Level level, String message) {
        logger.log(level, message);
    }

    public static void severe(String message) {
        log(Level.SEVERE, message);
    }

    public static void warning(String message) {
        log(Level.WARNING, message);
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void config(String message) {
        log(Level.CONFIG, message);
    }

    public static void fine(String message) {
        log(Level.FINE, message);
    }

    public static void finer(String message) {
        log(Level.FINER, message);
    }

    public static void finest(String message) {
        log(Level.FINEST, message);
    }

    public static void close() {
        if (fileHandler != null) {
            fileHandler.close();
        }
    }
}

