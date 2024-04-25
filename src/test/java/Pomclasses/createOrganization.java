package Pomclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Objectrepository.HomePage;
import Objectrepository.LoginPage;
import Objectrepository.OrganizationInfoPage;
import Objectrepository.OrganizationPage;
import Objectrepository.createnewOrgnizationPage;
import genericutility.excelFileUtility;
import genericutility.javaUtility;
import genericutility.propertyFileUtility;
import genericutility.webDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		// login page using pom class
		LoginPage lp = new LoginPage(driver);
		lp.getUserNameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		// Step2 : click on Organization link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		// Step3 : click on create org look up img
		OrganizationPage op = new OrganizationPage(driver);
		op.createOrgn();
		// Step4 : create organization with mandatory field
		createnewOrgnizationPage cno = new createnewOrgnizationPage(driver);
		cno.createnewOrgnization(orgName, industry);
		// Step6 : save
		cno.getSaveBtn();
		// Step7 : validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String result = oip.OrgNameInfo();

		if (result.contains(orgName)) {
			System.out.println("creation passed");
		} else {
			System.out.println("creation failed");
		}
		// log out of application
		hp.logOutOfApp(driver);
		System.out.println("log out is successsful");
	}

}
