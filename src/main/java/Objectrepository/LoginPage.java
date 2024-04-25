package Objectrepository;
/**
 * @author USER
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {// rule 1 create class
	// rule 2 identify elements using @anotation
	@FindBy(name ="user_name")
	private WebElement userNameEdt;
	@FindBy(name ="user_password")
	private WebElement passwordEdt;
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	//rule 3 create constructor to intialize
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule 4 provide getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
/**
 * This is generic bussinees library which can't import in this method
 * @param USERNAME
 * @param PASSWORD
 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	}


