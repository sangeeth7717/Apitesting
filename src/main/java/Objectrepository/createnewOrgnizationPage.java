package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.webDriverUtility;

public class createnewOrgnizationPage extends webDriverUtility {
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement accNameEdt;
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryTypeEdt;
	@FindBy(xpath = "(//input[contains(@title,'Save [Alt+S]')])")
	private WebElement saveBtn;

	public createnewOrgnizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccNameEdt() {
		return accNameEdt;
	}

	public WebElement getIndustryTypeEdt() {
		return industryTypeEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
/**
 * this is a bussiness class for create new organization
 * @author USER
 */
	public void createnewOrgnization(String orgName, String industry)
	{
		accNameEdt.sendKeys(orgName);
		handleDropdown(industryTypeEdt, industry);
		saveBtn.click();
	}
}
