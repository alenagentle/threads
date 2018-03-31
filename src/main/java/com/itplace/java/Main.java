package com.itplace.java;
import com.itplace.java.service.api.HtmlService;
import com.itplace.java.service.impl.HtmlServiceImpl;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
        String configInputFile1 = "resources/person1.properties";
        String configInputFile2 = "resources/person2.properties";
        String configeOutputFile1 = "out/person1.html";
        String configeOutputFile2 = "out/person2.html";
        PropertyReader reader1 = new PropertyReader(configInputFile1);
        PropertyReader reader2 = new PropertyReader(configInputFile2);
        Thread tr1 = new Thread(reader1);
        Thread tr2 = new Thread(reader2);
        tr1.start();
        tr2.start();

        tr1.join();
        tr2.join();

        HtmlService htmlService = new HtmlServiceImpl();
        htmlService.createHtml(configeOutputFile1, reader1.getMap());
        htmlService.createHtml(configeOutputFile2, reader2.getMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
