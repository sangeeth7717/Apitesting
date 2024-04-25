package TestngPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderTest {

	@Test(dataProvider = "getData")
	public void sampledata(String name,String model,String price)
	{
		System.out.println(name+"-"+model+"-"+price);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[4][3];
		data[0][0]="samsung";
		data[0][1]="s11";
		data[0][2]="18000";
		data[1][0]="Apple";
		data[1][1]="14pro";
		data[1][2]="25000";
		data[2][0]="vivo";
		data[2][1]="v19";
		data[2][2]="15000";
		data[3][0]="realme";
		data[3][1]="x15";
		data[3][2]="14000";
		return data;
		
	}
}
