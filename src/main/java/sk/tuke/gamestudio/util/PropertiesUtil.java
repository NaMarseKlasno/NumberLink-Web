package sk.tuke.gamestudio.util;

import java.io.IOException;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private PropertiesUtil() {}

    public static String get(String key) {
        return properties.getProperty(key);
    }

    // ***** если не сможет прочитать application.properties файл приложение упадет
    private static void loadProperties() {
         try (var inStream= PropertiesUtil.class.getClassLoader().getResourceAsStream("db/application.properties")) {
            properties.load(inStream);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }
}
