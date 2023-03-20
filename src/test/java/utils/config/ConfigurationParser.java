package utils.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationParser {
    public static Properties parse(String path) throws IOException {
        InputStream fileInputStream = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(fileInputStream);

        return prop;
    }
}
