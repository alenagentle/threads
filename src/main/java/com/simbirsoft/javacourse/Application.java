package com.simbirsoft.javacourse;

import com.simbirsoft.javacourse.data.PropertyReader;
import com.simbirsoft.javacourse.service.HtmlService;
import com.simbirsoft.javacourse.service.HtmlServiceImpl;

public class Application {

	public static void main(String[] args) {
        System.out.println("Hello world!");
		String configInputFile1 = "resources/person1.properties";
		String configInputFile2 = "resources/person2.properties";
		String configeOutputFile1 = "person1.html";
		String configeOutputFile2 = "person2.html";
		PropertyReader reader1 = new PropertyReader(configInputFile1);
		PropertyReader reader2 = new PropertyReader(configInputFile2);
		reader1.start();
		reader2.start();
		try {
			reader1.join();
			reader2.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		HtmlService htmlService = new HtmlServiceImpl();
		htmlService.createHtml(reader1.loadPropertyFile());
		htmlService.write(configeOutputFile1);
		htmlService.createHtml(reader2.loadPropertyFile());
		htmlService.write(configeOutputFile2);
	}
}
