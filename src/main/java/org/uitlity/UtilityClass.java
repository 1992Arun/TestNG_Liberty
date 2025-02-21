package org.uitlity;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	
	public static String getProperty(String key){
		Properties p = null;
		
		try {
			
			FileReader f = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Confic.properties");
			
			p = new Properties();
			
			
			p.load(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p.getProperty(key);
		
	}

}
