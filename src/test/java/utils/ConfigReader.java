package utils;


import java.io.*;
import java.util.Properties;

    public class ConfigReader {

        private static final Properties prop = new Properties();
          // This code work

        static {
            try {
                ClassLoader classLoader = ConfigReader.class.getClassLoader();

                InputStream input =
                        classLoader.getResourceAsStream("config/qa_env.properties");

                if (input == null) {
                    throw new RuntimeException(
                            "Cannot find qa_env.properties in resources/config");
                }
                prop.load(input);
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(
                        "Failed to load qa_env.properties", e);
            }
        }


        public static String getProperty(String key) {
          //  ConfigReader.readConfig();
            return prop.getProperty(key);
        }

           // this is  need    ConfigReader.readConfig();
//        public static void readConfig (){
//
//            File file = new File("./src/test/resources/config/qa_env.properties");
//
//            try {
//                FileInputStream propFile=new FileInputStream("./src/test/resources/config/qa_env.properties");
//                prop.load(propFile);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e +"Can not load property file with message ");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }



