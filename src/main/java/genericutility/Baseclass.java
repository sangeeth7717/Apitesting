package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import Objectrepository.HomePage;
import Objectrepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public WebDriver driver = null;
	public propertyFileUtility pUtil = new propertyFileUtility();
	public excelFileUtility eUtil = new excelFileUtility();
	public javaUtility jUtil = new javaUtility();
	public webDriverUtility wUtil = new webDriverUtility();

	@BeforeSuite(alwaysRun = true) // allways is used to all type of groups like Smoke and reggresion tesing
	public void bsconfig() {
		System.out.println("======db connection successful");
	}
   // @Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcconfig(/*String BROWSER*/) throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("======chrome launched=====");
		} else if (BROWSER.equalsIgnoreCase("firfox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("======firfox launched=====");
		} else {
			System.out.println("invalid browser");
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("========login succesful=========");
	}

	@AfterMethod(alwaysRun = true)
	public void amconfig() {
		HomePage hp = new HomePage(driver);
		hp.logOutOfApp(driver);
		System.out.println("========logout successfull========");
	}

	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acconfig() {
		driver.quit();
		System.out.println("=========Browser closed=========");
	}

	@AfterSuite(alwaysRun = true)
	public void asconfig() {
		System.out.println("=========db connetion closed=======");
	} 
}
