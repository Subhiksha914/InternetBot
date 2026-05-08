package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties = new Properties();

    static {

        try {

            FileInputStream file =
                    new FileInputStream("src/test/resources/config.properties");

            properties.load(file);

        }

        catch (IOException e) {

            System.out.println("Config file not found!");

            e.printStackTrace();

        }

    }

    public static String getBrowser() {

        return properties.getProperty("browser");

    }

    public static String getBaseUrl() {

        return properties.getProperty("baseUrl");

    }

    public static String getTimeout() {

        return properties.getProperty("timeout");

    }

}