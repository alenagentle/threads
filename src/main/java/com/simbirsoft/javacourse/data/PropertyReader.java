package com.simbirsoft.javacourse.data;

import java.io.*;
import java.util.Properties;

public class PropertyReader extends  Thread {
    private String configInputFile;
    private Properties prop;
    public PropertyReader(String configInputFile) {
        this.configInputFile = configInputFile;
    }

    public Properties loadPropertyFile()
    {
        prop = new Properties();
        try {
            prop.load(new BufferedReader(new InputStreamReader(new FileInputStream(this.configInputFile))));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return prop;
    }
}
