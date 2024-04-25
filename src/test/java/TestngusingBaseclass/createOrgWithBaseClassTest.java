package TestngusingBaseclass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Objectrepository.HomePage;
import Objectrepository.LoginPage;
import Objectrepository.OrganizationInfoPage;
import Objectrepository.OrganizationPage;
import Objectrepository.createnewOrgnizationPage;
import genericutility.Baseclass;
import genericutility.excelFileUtility;
import genericutility.javaUtility;
import genericutility.propertyFileUtility;
import genericutility.webDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrgWithBaseClassTest extends Baseclass {

	@Test(groups = "SmokeTesting")
	public void createOrgWithBaseclass() throws EncryptedDocumentException, IOException
	{
		
		String orgName = eUtil.readDataFromExcelFile("Organization", 1, 2) + jUtil.getRandomNumber();
		String industry = eUtil.readDataFromExcelFile("Organization", 1, 3);
	
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
		
	}
}
