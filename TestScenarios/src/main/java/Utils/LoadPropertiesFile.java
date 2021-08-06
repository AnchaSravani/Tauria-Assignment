package Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFile {
	
		public static Properties prop ;
		public void Load() throws IOException
		{
		
			
               prop =new Properties();
				
				try {
					String s= Utils.getRootDir();
					
					prop.load(new FileInputStream(
							s+"\\config.properties"));

		       
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
			
		}
}
