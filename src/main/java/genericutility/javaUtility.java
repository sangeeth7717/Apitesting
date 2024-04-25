package genericutility;

import java.util.Date;
import java.util.Random;

/**
 * This class consist of generic methods related to java
 * @author USER
 */
public class javaUtility {
/**
 * This method will get random number
 * @return
 */
	public int getRandomNumber()
	{
		Random r= new Random();
		return r.nextInt(999);
	}
	/**
	 * This method will get systemsdate
	 * @author USER
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		return d.toString();
	}
	/**
	 * This method will generate System date in format
	 * @return
	 */
	public String getSytemDateInformat()
	{
	
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String date= dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3];
	return date+" "+month+" "+year+" "+time;
	}
}
