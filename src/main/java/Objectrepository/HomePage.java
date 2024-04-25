package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.webDriverUtility;

public class HomePage extends webDriverUtility {
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadEdt;
	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement orgEdt;
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactEdt;
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productEdt;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminImg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignoutEdt;
	@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
	private WebElement oppurtunityEdt;
	public WebElement getOppurtunityEdt() {
		return oppurtunityEdt;
	}
	// intialaization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// getter methods
	public WebElement getLeadEdt() {
		return leadEdt;
	}

	public WebElement getOrgEdt() {
		return orgEdt;
	}

	public WebElement getContactEdt() {
		return contactEdt;
	}

	public WebElement getProductEdt() {
		return productEdt;
	}

	public WebElement getAdminImg() {
		return AdminImg;
	}

	public WebElement getSignoutEdt() {
		return SignoutEdt;
	}

	/**
	 * This are business library and it is used to click organization
	 * 
	 * @author USER
	 */
	public void clickOnOppurtunity() {
		oppurtunityEdt.click();
	}

	public void clickOnOrganization() {
		orgEdt.click();
	}

	public void cickOnContact() {
		contactEdt.click();
	}

	public void clickOnProduct() {
		productEdt.click();
	}

	public void logOutOfApp(WebDriver driver) {
		mouseOverAction(driver, AdminImg);
		SignoutEdt.click();
	}
}
