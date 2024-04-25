package GenericPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericutility.excelFileUtility;
import genericutility.javaUtility;
import genericutility.propertyFileUtility;
import genericutility.webDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		// genric method
		propertyFileUtility pUtil = new propertyFileUtility();
		excelFileUtility eUtil = new excelFileUtility();
		javaUtility jUtil = new javaUtility();
		webDriverUtility wUtil = new webDriverUtility();
		// read all required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		String orgName = eUtil.readDataFromExcelFile("Organization", 1, 2) + jUtil.getRandomNumber();
		String industry = eUtil.readDataFromExcelFile("Organization", 1, 3);
		// creating webdriver manager
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		// Step1 : login to application
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		// Step2 : click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		// Step3 : click on create org look up img
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// Step4 : create organization with mandatory field
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		// Step5 : choose industry drop down
		WebElement indus = driver.findElement(By.xpath("//select[@name='industry']"));
		wUtil.handleDropdown(indus, industry);
		// Step6 : save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		// Step7 : validate
		String result = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (result.contains(orgName)) {
			System.out.println("creation passed");
		} else {
			System.out.println("creation failed");
		}
		// log out of application
		WebElement adminimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseOverAction(driver, adminimg);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
