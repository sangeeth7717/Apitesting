package vtigerpractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createorganizationwithexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Step1 : Open file in java readable format
		FileInputStream File = new FileInputStream(".//src//test//resources//Testdata.xlsx");
		// step2 : create workbook factory
		Workbook wb = WorkbookFactory.create(File);
		// step3 : get control of sheet
		Sheet sh1 = wb.getSheet("Organization");
		// step4 : get control of row
		Row rw1 = sh1.getRow(1);
		// step5 : get control of cell
		Cell ce1 = rw1.getCell(2);
		Cell ce2 = rw1.getCell(3);
		String orgname = ce1.getStringCellValue();
		String industrytype = ce2.getStringCellValue();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Random ran= new Random();
		int r = ran.nextInt(999);
		System.out.println(r);
		//Step1 : login to application
				driver.get("http://localhost:8888/");
				driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
				driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//Step2 : click on Organization link
				driver.findElement(By.linkText("Organizations")).click();
		//Step3 : click on create org look up img
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//Step4 : create organization with mandatory field
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname+"+r+");
		//Step5 : choose industry drop down
				WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
				Select sel = new Select(industry);
				sel.selectByValue(industrytype);
		//Step6 : save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Step7 : validate
				String result = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if (result.contains("sangeeth")) {
					System.out.println("creation passed");
				} else {
					System.out.println("creation failed");
				}
		//Step8 : log out of application
				WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(adminimg).perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}

}
