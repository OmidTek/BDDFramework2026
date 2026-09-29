package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class YamlReader {

    private static Map<String, Object> data;

    static {
        try {
            Yaml yaml = new Yaml();

            InputStream input =
                    new FileInputStream("test-config.yml");

            data = yaml.load(input);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return data.get(key).toString();
    }

    public static String getEnvironmentUrl() {

        // First get environment: qa or demo
        String environment = get("environment");

        // Get the section for that environment
        Map<String, Object> envData =
                (Map<String, Object>) data.get(environment);

        // Get URL from that section
        return envData.get("url").toString();
    }
}