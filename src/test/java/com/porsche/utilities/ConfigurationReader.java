package com.porsche.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
        // this is the path of the location of the file
        String path = "configuration.properties";
        try {
            //reader for the file, java can not read files directly, it neds input stream
            //input stream takes the location of the files a constructor
            FileInputStream fileInputStream =new FileInputStream(path);
            // properties is used the read properties files, files with key value pairs
            properties = new Properties();
            // file contents are loaded to properties from inputstream
            properties.load(fileInputStream);
            // all input streams must be closed
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//  returns the value of property
    public static String getProperty (String property){
        return properties.getProperty(property);
    }
}
