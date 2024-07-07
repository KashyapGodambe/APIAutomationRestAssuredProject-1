package APIAutomationRestAssured.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	public static void main(String[] args) {
		
		
		
		

	}
	
	
	public static String readKey(String key)
	{
		Properties properties = new Properties();
		
		try {	
			
			FileInputStream fileInputStream = new FileInputStream("src/test/resources/data.properties");
			properties.load(fileInputStream);
			
			
		}
		catch(Exception ex){
			
			System.out.println(ex.getMessage());
		}
		
		return properties.getProperty(key);
		
	}

}
