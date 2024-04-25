package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgbtn;

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrg() {
		return createOrgbtn;
	}

	/**
	 * This bussiness class for create Organization
	 * 
	 * @author USER
	 */
	public void createOrgn() {
		createOrgbtn.click();
	}
}
