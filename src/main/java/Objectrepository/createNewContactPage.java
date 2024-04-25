package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.webDriverUtility;

public class createNewContactPage extends webDriverUtility {
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameEdt;
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement orgNameBtn;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement orgSearch;
	@FindBy(xpath="//input[@name='search']")
	private WebElement orgsearchbtn;
public createNewContactPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getLastNameEdt() {
	return lastNameEdt;
}
public WebElement getOrgNameBtn() {
	return orgNameBtn;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
public WebElement getOrgSearch() {
	return orgSearch;
}
public WebElement getOrgsearchbtn() {
	return orgsearchbtn;
}
/**
 *This is business class 
 * @author USER
 */
public void createNewContact(WebDriver driver, String contactName, String orgName)
{
	lastNameEdt.sendKeys(contactName);
	orgNameBtn.click();
	switchToWindow(driver, "Accounts");
	orgSearch.sendKeys(orgName);
	orgsearchbtn.click();
	driver.findElement(By.xpath("//a[text()='"+orgName +"']")).click();
	switchToWindow(driver, "Contacts");
	saveBtn.click();
}
}
