package vtigerpractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorganisationpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Random ran= new Random();
		int r = ran.nextInt(999);

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
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("sangeeth"+r+"");
//Step5 : choose industry drop down
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel = new Select(industry);
		sel.selectByValue("Chemicals");
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
