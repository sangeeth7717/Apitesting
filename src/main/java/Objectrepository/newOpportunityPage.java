package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.webDriverUtility;

public class newOpportunityPage extends webDriverUtility{
	@FindBy(xpath="//input[@name='potentialname']")
	private WebElement oppurtunityEdt;
	@FindBy(xpath="//select[@id='related_to_type']")
	private WebElement chooseOrgOrContactDD;
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img[@title='Select']")
	private WebElement selectListEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(id="search_txt")
	private WebElement OrgSearchText;
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement OrgSearchDD;
	@FindBy(xpath="//input[@name='search']")
	private WebElement orgSearchedt;
	//intiallization
	public newOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// getters
	public WebElement getOppurtunityEdt() {
		return oppurtunityEdt;
	}
	public WebElement getChooseOrgOrContactDD() {
		return chooseOrgOrContactDD;
	}
	public WebElement getSelectListEdt() {
		return selectListEdt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getOrgSearchText() {
		return OrgSearchText;
	}
	public WebElement getOrgSearchDD() {
		return OrgSearchDD;
	}
	public WebElement getOrgSearchedt() {
		return orgSearchedt;
	}
	/**
	 * This is Bussiness Class used to access the create New Opportunity
	 * @author USER 
	 */
	public void CreateOppwithOrg(WebDriver driver, String OpportunityName, String orgName)
	{
		oppurtunityEdt.sendKeys(OpportunityName);
		handleDropdown(chooseOrgOrContactDD, orgName);
		selectListEdt.click();
		switchToWindow(driver, "Accounts");
		OrgSearchText.sendKeys(orgName);
		handleDropdown("Organization Name", OrgSearchDD);
		orgSearchedt.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Potentials");
		saveBtn.click();
		
	}
}
