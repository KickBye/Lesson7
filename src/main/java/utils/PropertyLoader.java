package utils;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {

    //Получение значения по ключу
    public static String loadProperty(final String key) {
        Properties properties = getAllPropFromFile("project.properties");
        return properties.getProperty(key);
    }

    public static String loadProperty(final String key, String path) {
        Properties properties = getAllPropFromFile(path);
        return properties.getProperty(key);
    }

    public static Properties getAllPropFromFile(final String path) {
        Properties properties = new Properties();

//Объект где будут все переменные
        FileInputStream fs = null;
        InputStreamReader is = null;

        try {
            try {
                fs = new FileInputStream("src/main/resources/" + path);
                is = new InputStreamReader(fs, "UTF-8");
            } catch (FileNotFoundException | UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                properties.load(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            } finally {
                if (fs != null) {
                    try {
                        fs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return properties;
        }
    }

