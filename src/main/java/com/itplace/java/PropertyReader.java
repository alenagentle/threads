package com.itplace.java;

import com.itplace.java.data.DataKeys;
import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class PropertyReader extends Thread {
    private String configInputFile;
    private Properties prop;
    private HashMap <String, String> map;

    public PropertyReader(String configInputFile)
    {
        this.configInputFile = configInputFile;
    }

    public void loadPropertyFile()
    {
        prop = new Properties();
        try {
            prop.load(new BufferedReader(new InputStreamReader(new FileInputStream(this.configInputFile))));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void fillMap()
    {
        map = new HashMap<String, String>();
        map.put(DataKeys.FIO, prop.getProperty(DataKeys.FIO));
        map.put(DataKeys.DOB, prop.getProperty(DataKeys.DOB));
        map.put(DataKeys.PHONE, prop.getProperty(DataKeys.PHONE));
        map.put(DataKeys.EMAIL, prop.getProperty(DataKeys.EMAIL));
        map.put(DataKeys.SKYPE, prop.getProperty(DataKeys.SKYPE));
        map.put(DataKeys.TARGET, prop.getProperty(DataKeys.TARGET));
        map.put(DataKeys.EXPERIENCES, prop.getProperty(DataKeys.EXPERIENCES));
        map.put(DataKeys.EDUCATIONS, prop.getProperty(DataKeys.EDUCATIONS));
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    @Override
    public void run()
    {
        loadPropertyFile();
        fillMap();
    }
}
