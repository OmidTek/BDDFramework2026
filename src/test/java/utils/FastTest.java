package utils;

public class FastTest {

    public static void main(String[] args) {

        System.out.println(YamlReader.get("browser"));
        System.out.println(YamlReader.get("environment"));
        System.out.println(YamlReader.get("username"));
        System.out.println(YamlReader.get("suiteFile"));
    }
}
