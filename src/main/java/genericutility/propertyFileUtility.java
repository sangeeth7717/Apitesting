package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of generic method related to property file
 * @author USER
 */
public class propertyFileUtility {
	
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream File=new FileInputStream(IconstantlyUtility.propertyFilePath);
		Properties pObj = new Properties();
		pObj.load(File);
		String Value = pObj.getProperty(Key);
		return Value;
	}

}
